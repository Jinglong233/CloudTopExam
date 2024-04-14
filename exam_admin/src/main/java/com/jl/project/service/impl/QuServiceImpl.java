package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.jl.project.entity.dto.AddQuAndAnswerDTO;
import com.jl.project.entity.dto.RandomSelectQuDTO;
import com.jl.project.entity.dto.UpdateQuAndAnswerDTO;
import com.jl.project.entity.po.ClassfiySelect;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.QuLevel;
import com.jl.project.enums.QuType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.QuAnswerMapper;
import com.jl.project.mapper.QuMapper;
import com.jl.project.mapper.RepoMapper;
import com.jl.project.service.QuService;
import com.jl.project.service.UserService;
import com.jl.project.utils.CommonUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

import static com.jl.project.enums.QuType.SHORTANSWER;

;

/**
 * @Description:题目表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("quService")
public class QuServiceImpl implements QuService {

    @Resource
    private QuMapper<Qu, QuQuery> quMapper;

    @Resource
    private UserService userService;

    @Resource
    private QuAnswerMapper<QuAnswer, QuAnswerQuery> quAnswerMapper;

    @Resource
    private RepoMapper<Repo, RepoQuery> repoMapper;

    /**
     * 根据条件查询列表
     */
    public List<Qu> findListByParam(QuQuery query) {
        return this.quMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(QuQuery query) {
        return this.quMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Qu> findListByPage(QuQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Qu> list = this.findListByParam(query);
        PaginationResultVO<Qu> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Transactional
    public Boolean add(AddQuAndAnswerDTO bean) throws BusinessException {
        if (bean == null) {
            throw new BusinessException("缺少参数");
        }
        // 添加题目
        Qu qu = new Qu();
        BeanUtil.copyProperties(bean, qu);
        String quId = CommonUtil.getRandomId();
        qu.setId(quId);
        qu.setCreateTime(new Date());
        qu.setCreateBy(userService.getLoginUserInfo().getId());
        Integer insert = quMapper.insert(qu);
        if (insert <= 0) {
            throw new BusinessException("保存题目失败");
        }
        Integer quType = bean.getQuType();
        if (quType == SHORTANSWER.getValue()) {
            // 如果是简答题，题目分析就是答案，所以不用创建quAnswer
            return insert > 0;
        }

        // 获取选项列表，添加选项
        List<QuAnswer> quAnswerList = bean.getQuAnswerList();
        if (quAnswerList != null) {
            int tag = 65;

            for (QuAnswer quAnswer : quAnswerList) {
                quAnswer.setId(CommonUtil.getRandomId());
                quAnswer.setQuId(quId);
                if (quType.equals(QuType.MULTI) || quType.equals(QuType.RADIO)) {
                    quAnswer.setTag(Character.toString((char) tag++));
                }
                // 填空题的所有quAnswer都是正确的
                if (quType.equals(QuType.FILL.getValue())) {
                    quAnswer.setIsRight(1);
                }
                Integer add = quAnswerMapper.insert(quAnswer);
                if (add <= 0) {
                    throw new BusinessException("保存选项失败");
                }
            }
        }


        // 更新关联题库数据
        String repoId = qu.getRepoId();
        Repo repo = repoMapper.selectById(repoId);
        if (repo == null) {
            throw new BusinessException("更新题库失败");
        }
        repo.setUpdateTime(new Date());
        repo.setUpdateBy(userService.getLoginUserInfo().getId());
        if (SHORTANSWER.getValue() != quType) { // 不是简答题都为客观题
            repo.setSubCount(repo.getSubCount() + 1);
        } else {
            repo.setObjCount(repo.getObjCount() + 1);
        }
        repo.setTotalCount(repo.getObjCount() + repo.getObjCount());
        Integer result = repoMapper.updateById(repo, repoId);
        if (result <= 0) {
            throw new BusinessException("更新题库失败");
        }
        return true;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<Qu> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.quMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<Qu> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.quMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public QuAndAnswerVo getQuById(String id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("缺少参数");
        }
        QuAndAnswerVo quAndAnswerVo = new QuAndAnswerVo();
        Qu qu = quMapper.selectById(id);
        if (qu == null) {
            throw new BusinessException("题目不存在");
        }
        BeanUtil.copyProperties(qu, quAndAnswerVo);
        String quId = qu.getId();
        // 获取关联选项(根据tag保证顺序)
        QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
        quAnswerQuery.setQuId(quId);
        List<QuAnswer> quAnswerList = quAnswerMapper.selectList(quAnswerQuery);
        if (quAnswerList != null && quAnswerList.size() != 0) {
            if (qu.getQuType().equals(QuType.RADIO.getValue()) ||
                    qu.getQuType().equals(QuType.MULTI.getValue())) {
                quAnswerList = quAnswerList.stream()
                        .sorted(Comparator.comparing(QuAnswer::getTag))
                        .collect(Collectors.toList());
            }

            quAndAnswerVo.setQuAnswerList(quAnswerList);
        }
        return quAndAnswerVo;
    }

    /**
     * 根据Id更新
     */
    @Transactional
    public Boolean updateQuById(UpdateQuAndAnswerDTO bean) throws BusinessException {
        if (bean == null) {
            throw new BusinessException("缺少参数");
        }

        // 获取原有题库
        String quId = bean.getId();
        Qu oldQu = quMapper.selectById(quId);
        if (oldQu == null) {
            throw new BusinessException("更新的题目不存在");
        }
        String oldRepoId = oldQu.getRepoId();
        String newRepoId = bean.getRepoId();
        // 如果两个repoId不相等，则代表题库发生修改
        if (oldRepoId != newRepoId) {
            // 修改新题库相关信息
            Repo newRepo = repoMapper.selectById(newRepoId);
            if (newRepo == null) {
                throw new BusinessException("找不到相关题库信息");
            }
            // 判断题型（主观题or客观题）
            if (SHORTANSWER.getValue() != oldQu.getQuType()) { // 不是简答题都为客观题
                newRepo.setSubCount(newRepo.getSubCount() + 1);
            } else {
                newRepo.setObjCount(newRepo.getObjCount() + 1);
            }
            newRepo.setTotalCount(newRepo.getTotalCount() + 1);
            Integer updateRepo = repoMapper.updateById(newRepo, newRepoId);
            if (updateRepo <= 0) {
                throw new BusinessException("更新题库失败");
            }

            // 修改旧题库相关信息
            Repo oldRepo = repoMapper.selectById(oldRepoId);
            if (oldRepo == null) {
                throw new BusinessException("找不到相关题库信息");
            }
            // 判断题型（主观题or客观题）
            if (SHORTANSWER.getValue() != oldQu.getQuType()) { // 不是简答题都为客观题
                oldRepo.setSubCount(oldRepo.getSubCount() - 1);
            } else {
                oldRepo.setObjCount(oldRepo.getObjCount() - 1);
            }
            oldRepo.setTotalCount(oldRepo.getTotalCount() - 1);
            updateRepo = repoMapper.updateById(oldRepo, oldRepoId);
            if (updateRepo <= 0) {
                throw new BusinessException("更新题库失败");
            }
        }

        // 提取题目
        Qu qu = new Qu();
        BeanUtil.copyProperties(bean, qu);
        qu.setUpdateTime(new Date());
        if (quId == null) {
            throw new BusinessException("更新题目失败");
        }

        // 更新题目
        Integer result = quMapper.updateById(qu, quId);
        if (result <= 0) {
            throw new BusinessException("更新题目失败");
        }

        // 提取选项
        List<QuAnswer> quAnswerList = bean.getQuAnswerList();
        if (quAnswerList != null && quAnswerList.size() != 0) {
            for (QuAnswer quAnswer : quAnswerList) {
                String quAnswerId = quAnswer.getId();
                if (quAnswerId == null || "".equals(quAnswerId)) { // 说明是新增的
                    quAnswer.setId(CommonUtil.getRandomId());
                    quAnswer.setQuId(quId);
                    quAnswer.setTag(Character.toString((char) (64 + quAnswerList.size())));
                    Integer add = quAnswerMapper.insert(quAnswer);
                    if (add <= 0) {
                        throw new BusinessException("更新选项出错");
                    }
                    continue;
                }
                Integer integer = quAnswerMapper.updateById(quAnswer, quAnswerId);
                if (integer <= 0) {
                    throw new BusinessException("更新选项出错");
                }
            }
        }

        return true;
    }

    /**
     * 根据Id删除
     */
    @Transactional
    public Boolean deleteQuById(String id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("缺少参数");
        }

        String quId = id;
        Qu qu = quMapper.selectById(quId);
        Integer quType = qu.getQuType();
        String repoId = qu.getRepoId();
        // 删除题目
        Integer integer = quMapper.deleteById(quId);
        if (integer <= 0) {
            throw new BusinessException("删除题目失败");
        }

        // 删除关联选项
        QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
        quAnswerQuery.setQuId(quId);
        List<QuAnswer> quAnswerList = quAnswerMapper.selectList(quAnswerQuery);
        if (quAnswerList != null && quAnswerList.size() != 0) {
            for (QuAnswer quAnswer : quAnswerList) {
                String quAnswerId = quAnswer.getId();
                if (quAnswerId == null) {
                    continue;
                }
                Integer byId = quAnswerMapper.deleteById(quAnswerId);
                if (byId <= 0) {
                    throw new BusinessException("删除选项出错");
                }
            }
        }
        // 删除相关题库题目数量(题库不存在不能影响题目的删除)
        if (repoId != null) {
            Repo repo = repoMapper.selectById(repoId);
            if (repo != null) {
                // 判断主客观题
                if (SHORTANSWER.getValue() != quType) { // 客观题
                    repo.setSubCount(repo.getSubCount() - 1);
                } else { // 主观题
                    repo.setObjCount(repo.getObjCount() - 1);
                }
                repo.setTotalCount(repo.getSubCount() + repo.getObjCount());
                repo.setUpdateTime(new Date());
                repo.setUpdateBy(userService.getLoginUserInfo().getId());
                Integer update = repoMapper.updateById(repo, repoId);
                if (update <= 0) {
                    throw new BusinessException("更新题库失败");
                }
            }

        }

        return true;
    }

    /**
     * 随机抽取题目
     *
     * @param selectQuDTO
     * @return
     * @throws BusinessException
     */
    @Override
    public List<QuAndAnswerVo> randomSelectQu(RandomSelectQuDTO selectQuDTO) throws BusinessException {
        if (selectQuDTO == null) {
            throw new BusinessException("缺少参数");
        }


        List<String> excludes = selectQuDTO.getExcludes();
        if (excludes == null) {
            excludes = new ArrayList<String>();
        }

        String repoId = selectQuDTO.getRepoId();
        if (repoId == null || "".equals(repoId)) {
            throw new BusinessException("参数错误");
        }
        Integer quType = selectQuDTO.getQuType();
        if (quType == null) {
            throw new BusinessException("参数错误");
        }
        List<ClassfiySelect> levels = selectQuDTO.getLevels();
        if (levels == null || levels.size() == 0) {
            throw new BusinessException("参数错误");
        }


        // 1. 获取对应题库对应题型的题目
        QuQuery quQuery = new QuQuery();
        quQuery.setRepoId(repoId);
        quQuery.setQuType(quType);
        List<Qu> quList = quMapper.selectList(quQuery);

        // 2. 获取题目分类列表
        Map<String, List<Qu>> map = quList.stream().collect(Collectors.groupingBy(qu -> {
            if (qu.getLevel() == QuLevel.EASY.getValue()) {
                return QuLevel.EASY.getLevel();
            } else if (qu.getLevel() == QuLevel.HARD.getValue()) {
                return QuLevel.HARD.getLevel();
            } else {
                return "";
            }
        }));
        List<Qu> easyList = map.get(QuLevel.EASY.getLevel());
        List<Qu> hardList = map.get(QuLevel.HARD.getLevel());


        // 3. 分类抽题
        for (ClassfiySelect level : levels) {
            if (level != null && QuLevel.EASY.getValue() == level.getLevel()) { // 简单题
                Integer level1 = level.getLevel();
                // 获取抽取的题数
                Integer num = level.getNum();
                // 抽题
                easyList = selectQu(easyList, excludes, num);
            } else if (level != null && QuLevel.HARD.getValue() == level.getLevel()) { // 困难题
                Integer level1 = level.getLevel();
                // 获取抽取的题数
                Integer num = level.getNum();
                // 抽题
                hardList = selectQu(hardList, excludes, num);
            }
        }

        List<QuAndAnswerVo> result = new ArrayList<>();
        List<Qu> mergeList = new ArrayList<>(easyList);
        mergeList.addAll(hardList);
        // 4. 查询题目对应的选项（选项顺序按照标签来）
        for (Qu qu : mergeList) {
            QuAndAnswerVo quAndAnswerVo = new QuAndAnswerVo();
            String quId = qu.getId();
            BeanUtil.copyProperties(qu, quAndAnswerVo);
            // 查找对应选项
            QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
            quAnswerQuery.setQuId(quId);
            List<QuAnswer> list = quAnswerMapper.selectList(quAnswerQuery);
            if (quType.equals(QuType.RADIO.getValue()) ||
                    quType.equals(QuType.MULTI.getValue())) {
                // 单选多选才有Tag
                list = list.stream().sorted(Comparator.comparing(QuAnswer::getTag)).collect(Collectors.toList());
            }
            quAndAnswerVo.setQuAnswerList(list);
            result.add(quAndAnswerVo);
        }

        return result;
    }

    /**
     * 获取详细题目列表
     *
     * @param query
     * @return
     */
    @Override
    public List<QuAndAnswerVo> loadDetailDataList(QuQuery query) {
        if (query == null) {
            throw new BusinessException("缺少参数");
        }
        List<Qu> quList = quMapper.selectList(query);
        if (quList == null || quList.size() == 0) {
            return Collections.emptyList();
        }
        List<QuAndAnswerVo> quAndAnswerVoList = quList.stream().map((qu) -> {
            String quId = qu.getId();
            if (quId == null) {
                throw new BusinessException("题目错误");
            }
            QuAndAnswerVo quAndAnswerVo = getQuById(quId);
            return quAndAnswerVo;
        }).collect(Collectors.toList());
        return quAndAnswerVoList;
    }

    /**
     * 获取详细题目列表(排除之后的)
     *
     * @param query
     * @return
     */
    @Override
    public List<QuAndAnswerVo> loadExcludeDataList(QuExcludeQuery query) throws BusinessException {
        if (query == null) {
            throw new BusinessException("缺少参数");
        }
        List<String> excludes = query.getExcludes();
        if (excludes == null) {
            throw new BusinessException("缺少参数");
        }
        QuQuery quQuery = new QuQuery();
        BeanUtil.copyProperties(query, quQuery);
        List<QuAndAnswerVo> quAndAnswerVos = loadDetailDataList(quQuery);
        if (quAndAnswerVos == null) {
            return Collections.emptyList();
        }
        quAndAnswerVos = quAndAnswerVos.stream().filter((quAndAnswerVo) -> {
            return !excludes.contains(quAndAnswerVo.getId());
        }).collect(Collectors.toList());
        return quAndAnswerVos;
    }

    /**
     * 获取题目总数
     *
     * @param query
     * @return
     */
    @Override
    public Integer getQuCount(QuQuery query) throws BusinessException {
        if (query == null) {
            throw new BusinessException("缺少参数");
        }
        Integer count = quMapper.selectCount(query);
        return count;
    }

    /**
     * 导出
     *
     * @param response
     */
    @Override
    public void export(HttpServletResponse response) throws BusinessException, IOException {
        List<QuAndAnswerVo> quAndAnswerVos = loadDetailDataList(new QuQuery());
        if (quAndAnswerVos == null) {
            throw new BusinessException("没有数据");
        }
        List<Map<String, Object>> rows = new ArrayList<>();

        for (QuAndAnswerVo quAndAnswerVo : quAndAnswerVos) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("题目内容", quAndAnswerVo.getContent());
            row.put("题目图片", quAndAnswerVo.getImage());
            row.put("题目难度", quAndAnswerVo.getLevel());
            row.put("题目分析", quAndAnswerVo.getAnalysis());
            row.put("题型", quAndAnswerVo.getQuType());
            List<QuAnswer> quAnswerList = quAndAnswerVo.getQuAnswerList();
            for (QuAnswer quAnswer : quAnswerList) {
                row.put("是否为答案", quAnswer.getIsRight());
                row.put("选项分析", quAnswer.getAnalysis());
                row.put("选项图片", quAnswer.getImage());
                row.put("选项标签" + quAnswer.getTag(), quAnswer.getContent());
            }
            rows.add(row);
        }
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(rows, true);

        // 获取我们的输出流
        final OutputStream output = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("stu.xlsx", "UTF-8"));
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        writer.flush(output, true);
        writer.close();
        // 这里可以自行关闭资源或者写一个关闭资源的工具类
        IoUtil.close(output);
    }

    @Override
    @Transactional
    public Boolean importQuestions(MultipartFile file,String repoId) throws BusinessException{
        String filename = file.getOriginalFilename();

        if (!(filename.endsWith(".xls") || filename.endsWith(".xlsx"))) {
            throw new BusinessException("文件上传格式错误，请重新上传");
        }

        if(repoId == null || "".equals(repoId.trim())){
            throw new BusinessException("请选择需要导入的题库");
        }


        //获取工作簿
        Workbook book = null;
        try {

            InputStream inputStream = file.getInputStream();
            // excel类型判断
            if ((filename.endsWith(".xls"))) {
                book = new HSSFWorkbook(inputStream);

            } else if (filename.endsWith(".xlsx")) {
                book = new XSSFWorkbook(inputStream);
            }


        } catch (Exception e) {
            throw new BusinessException("导入文件出错");
        }
        //获取工作表
        Sheet sheet = book.getSheetAt(0);
        // 获取总行数
        int totalRow = sheet.getLastRowNum();

        // 总题数
        int totalCount = 0;
        // 主观题数
        int subCount = 0;
        // 客观题数
        int objCount = 0;

        // 题目集合
        List<Qu> quList = new ArrayList<>();

        // 题目选项集合
        List<QuAnswer> quAnswerList = new ArrayList<>();

        // 遍历行
        for (int i = 2; i < totalRow; i++) {
            Row row = sheet.getRow(i);
            Qu qu = new Qu();
            // 设置所属题库
            qu.setRepoId(repoId);

            qu.setRepoText("系统题库");
            // 设置创建时间
            qu.setCreateTime(new Date());
            // 设置QuId
            String quId = CommonUtil.getRandomId();
            qu.setId(quId);

            // 题型
            String quType = row.getCell(0).getStringCellValue();
            if (quType.equals(QuType.RADIO.getType())) {
                qu.setQuType(QuType.RADIO.getValue());
            } else if (quType.equals(QuType.MULTI.getType())) {
                qu.setQuType(QuType.MULTI.getValue());
            } else if (quType.equals(QuType.FILL.getType())) {
                qu.setQuType(QuType.FILL.getValue());
            } else if (quType.equals(QuType.JUDGE.getType())) {
                qu.setQuType(QuType.JUDGE.getValue());
            } else if (quType.equals(QuType.SHORTANSWER.getType())) {
                qu.setQuType(QuType.SHORTANSWER.getValue());
            }

            if (quType.equals(QuType.SHORTANSWER.getType())) {
                subCount++;
            } else {
                objCount++;
            }
            // 难易程度
            String level = row.getCell(1).getStringCellValue();
            if (level.equals(QuLevel.EASY.getLevel())) {// 简单
                qu.setLevel(QuLevel.EASY.getValue());
            } else if (level.equals(QuLevel.HARD.getLevel())) { // 困难
                qu.setLevel(QuLevel.HARD.getValue());
            } else {
                qu.setLevel(QuLevel.HARD.getValue());
            }
            // 题干
            String content = row.getCell(2).getStringCellValue();
            if (content != null && content.trim() != "") {
                qu.setContent(content);
            }

            // 分析
            String analysis = row.getCell(12).getStringCellValue();
            if (analysis != null && analysis.trim() != "") {
                qu.setAnalysis(analysis);
            }


            // 答案
            String answer = row.getCell(11).getStringCellValue();


            if (!quType.equals(QuType.JUDGE.getType())) { // 判断题的excel选项都为空，所以得在外层做判断
                // 选项
                for (int j = 3; j <= 10; j++) {
                    String select = row.getCell(j).getStringCellValue();
                    // 创建quAnswer
                    if (select != null && select.trim() != "") {
                        QuAnswer quAnswer = new QuAnswer();
                        // 设置quAnswerId
                        String quAnswerId = CommonUtil.getRandomId();
                        quAnswer.setId(quAnswerId);

                        // 设置题目Id
                        quAnswer.setQuId(quId);
                        String tag = String.valueOf((char) ('A' + j - 3));
                        // 判断题型
                        if (quType.equals(QuType.RADIO.getType()) ||
                                quType.equals(QuType.MULTI.getType())) { // 如果不是简答题和判断题
                            // 设置内容
                            quAnswer.setContent(select.split(".") == null ? select.split(".")[1] : select);

                            // 判断该选项是否是答案
                            if (answer.contains(tag)) {
                                quAnswer.setIsRight(1);
                            } else {
                                quAnswer.setIsRight(0);
                            }
                            // 设置编号
                            quAnswer.setTag(tag);
                        } else if (quType.equals(QuType.SHORTANSWER.getType())) { // 简答题
                            continue;
                        } else if (quType.equals(QuType.FILL.getType())) { // 填空题
                            // 设置内容
                            quAnswer.setContent(select.split(".") == null ? select.split(".")[1] : select);

                            // 填空题的选项都是答案
                            quAnswer.setIsRight(1);
                        }
                        quAnswerList.add(quAnswer);
                    }
                }
            } else {
                // 判断题和选择题一样;区别就是得手动写上对错
                QuAnswer rightAnswer = new QuAnswer();
                rightAnswer.setId(CommonUtil.getRandomId());
                rightAnswer.setContent("正确");
                rightAnswer.setQuId(quId);


                QuAnswer errorAnswer = new QuAnswer();
                errorAnswer.setId(CommonUtil.getRandomId());
                errorAnswer.setContent("错误");
                errorAnswer.setQuId(quId);

                // 判断对错
                if (answer.trim().equals("正确")) {
                    rightAnswer.setIsRight(1);
                    errorAnswer.setIsRight(0);
                } else {
                    rightAnswer.setIsRight(0);
                    errorAnswer.setIsRight(1);
                }

                quAnswerList.add(rightAnswer);
                quAnswerList.add(errorAnswer);
            }

            quList.add(qu);
            // 题数累加
            totalCount++;
        }
        // 批量插入题目
        Integer insert = quMapper.insertBatch(quList);
        if (insert <= 0) {
            throw new BusinessException("题目插入出错");
        }

        // 批量插入选项
        Integer quAnswerInsert = quAnswerMapper.insertBatch(quAnswerList);
        if (quAnswerInsert <= 0) {
            throw new BusinessException("选项插入出错");
        }

        // 更新关联题库
        Repo repo = repoMapper.selectById(repoId);
        if(repo==null){
            throw new BusinessException("请选择题库");
        }
        repo.setSubCount(subCount);
        repo.setObjCount(objCount);
        repo.setTotalCount(totalCount);
        Integer integer = repoMapper.updateById(repo, repo.getId());

        if (integer <= 0) {
            throw new BusinessException("关联题库更新失败");
        }
        try {
            book.close();
        } catch (IOException e) {
            throw new BusinessException("文件出错");
        }
        return true;
    }

    /**
     * 随机抽取指定数量的题目
     *
     * @param quList
     * @param exclude
     * @return
     */
    private List<Qu> selectQu(List<Qu> quList, List<String> exclude, Integer number) throws BusinessException {
        if (number <= 0) {
            return Collections.emptyList();
        }
        if (quList == null || quList.isEmpty()) {
            throw new BusinessException("题目列表为空");
        }

        // 1. 排除exclude中的题目
        quList = quList.stream().filter((qu) -> {
            return !exclude.contains(qu.getId());
        }).collect(Collectors.toList());

        // 2. 抽题
        // 2.1 判断剩余题目数量是否大于number
        Collections.shuffle(quList);
        if (quList.size() <= number) {
            // 小于则返回所有题目
            return quList;
        } else {
            // 大于则随机抽取
            return quList.subList(0, number);
        }

    }


}