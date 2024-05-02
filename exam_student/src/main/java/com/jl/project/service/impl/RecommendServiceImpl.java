package com.jl.project.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.jl.project.entity.po.Book;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.BookMapper;
import com.jl.project.mapper.DepartmentMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.RecommendService;
import com.jl.project.utils.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
    private static final Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private BookMapper<Book, BookQuery> bookMapper;
    @Resource
    private DepartmentMapper<Department, DepartmentQuery> departmentMapper;


    // 向当前用户推荐训练题目的数量
    public final static int RECOMMENDER_NUM = 5;


    @Override
    public List<String> getRecommendQuList() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        // 获取同专业的所有学生Id
        String deptCode = loginUserInfo.getDeptCode();
        // 获取年级
        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setDeptCode(deptCode.substring(0, deptCode.length() - 3));
        departmentQuery.setDeptLevel(2);
        List<Department> classList = departmentMapper.selectList(departmentQuery);
        if (classList == null || classList.size() == 0) {
            throw new BusinessException("该用户所在部门无父部门");
        }
        Department grade = classList.get(0);
        // 获取专业
        String parentCode = grade.getParentCode();

        // 获取专业下的所有用户
        UserQuery userQuery = new UserQuery();
        userQuery.setDeptCodeFuzzy(parentCode);
        List<User> userList = userMapper.selectList(userQuery);
        // 获取用户的Id集合
        List<String> userIds = userList.stream().map(user -> {
            return user.getId();
        }).collect(Collectors.toList());

        logger.info("同专业所有人的集合（包括自己）：{}", userIds);

        // 查询在book中的user，并且这些user得在userId中
        List<Book> bookList = bookMapper.getBookListByUserIds(userIds);

        // 统计每个用户的错题分类
        Map<String, List<Book>> collect =
                bookList.stream().collect(Collectors.groupingBy(Book::getUserId));
        logger.info("移除对照组前同专业人的错题集合分类：{}", bookList);

        // 计算临近系数，以当前用户的错题列表作为对照组
        List<Book> currentUser = collect.remove(loginUserInfo.getId());
        logger.info("移除对照组后同专业人的错题集合分类：{}", collect);

        // 当前用户没有错题
        if (currentUser == null) {
            throw new BusinessException("您还未有错题记录，可以先去做几场训练哦！");
        }

        List<String> currentUserQuList =
                currentUser.stream().map(book -> {
                    return book.getQuId();
                }).collect(Collectors.toList());
        logger.info("对照组错题集合：{}", currentUserQuList);

        // CN指标集合就是两个集合的交集
        List<Integer> resultList = new ArrayList<>();

        // jaccard指标集合
        List<Double> jaccardResultList = new ArrayList<>();

        //新建我们需要的以指标为key，以错题集合为value的结果map
        //Map集合的key是不可重复的，但是我们考虑相似系数有重复的概率，因此集合我们使用IdentityHashMap实现类
        Map<Double, List<Book>> jaccardResultQuList = new IdentityHashMap<>();
        for (Map.Entry<String, List<Book>> entry : collect.entrySet()) {
            List<String> entryQuList = entry.getValue().stream().map(book -> {
                return book.getQuId();
            }).collect(Collectors.toList());
            resultList.add(getIntersectionSize(currentUserQuList, entryQuList));
            jaccardResultList.add(jaccardRecommend(currentUserQuList, entryQuList));
            // 以jaccard系数作为key，当前的错题集合作为value
            jaccardResultQuList.put(jaccardRecommend(currentUserQuList, entryQuList), entry.getValue());
        }

        logger.info("CN指标集合：{}", resultList);
        logger.info("Jaccard近邻指标集合：{}", jaccardResultList);
        logger.info("以Jaccard相似系数计算结果，得到对应的集合列表：{}", jaccardResultQuList);

        // 按照
        List<String> list = sortJaccardResult(jaccardResultQuList);

        // 移除自己的错题
        list = CollectionUtil.subtractToList(list,currentUserQuList);

        logger.info("推荐结果：{}", list);

        return list;
    }

    /**
     * 获取两个list交集的个数
     *
     * @return
     */
    private Integer getIntersectionSize(List<String> arr1, List<String> arr2) {
        return CollectionUtil.intersection(
                arr1, arr2
        ).stream().collect(Collectors.toList()).size();
    }

    /**
     * 获取两个list并集的个数
     *
     * @return
     */
    private Integer getUnionSize(List<String> arr1, List<String> arr2) {
        return CollectionUtil.union(
                arr1, arr2
        ).stream().collect(Collectors.toList()).size();
    }

    /**
     * 计算jaccard相似系数 两个集合的交集/两个集合的并集
     *
     * @return
     */
    private Double jaccardRecommend(List<String> arr1, List<String> arr2) {
        return (double) getIntersectionSize(arr1, arr2) / (double) getUnionSize(arr1, arr2);
    }

    /**
     * 对jaccard map结果集进行排序，给出最后的推荐结果
     */
    private List<String> sortJaccardResult(
            Map<Double, List<Book>> jaccardResultMap) {
        // 将键转换为列表
        List<Map.Entry<Double, List<Book>>> entries = new ArrayList<>(jaccardResultMap.entrySet());


        // 创建自定义的Comparator
        Comparator<Map.Entry<Double, List<Book>>> comparator = new Comparator<Map.Entry<Double, List<Book>>>() {
            @Override
            public int compare(Map.Entry<Double, List<Book>> entry1, Map.Entry<Double, List<Book>> entry2) {
                // 先根据key来排序
                int result = Double.compare(entry1.getKey(), entry2.getKey());
                // 当key相等的时候，在根据题目做错的次数总和作比较
                if (result == 0) {
                    // 计算属性值的组合并进行比较
                    int sum1 = 0;
                    for (Book book : entry1.getValue()) {
                        sum1 += book.getWrongCount();
                    }

                    int sum2 = 0;
                    for (Book book : entry2.getValue()) {
                        sum2 += book.getWrongCount();
                    }
                    return Integer.compare(sum1, sum2);
                } else {
                    return result;
                }
            }
        };

        // 对键值对列表进行排序
        Collections.sort(entries, comparator);

        // 创建新的IdentityHashMap，并按排序后的键值对顺序放入键值对
        IdentityHashMap<Double, List<Book>> sortedMap = new IdentityHashMap<>();
        for (Map.Entry<Double, List<Book>> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        List<String> result = new ArrayList<>();
        // 给出最后的推荐结果（并集）
        for (Map.Entry<Double, List<Book>> entry : sortedMap.entrySet()) {
            List<String> collect = entry.getValue().stream().map(book -> {
                return book.getQuId();
            }).collect(Collectors.toList());
            result = CollectionUtil.union(result, collect).stream().collect(Collectors.toList());
        }
        return result;

    }

}
