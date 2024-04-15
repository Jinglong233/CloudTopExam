package com.jl.project.utils;

import com.jl.project.entity.po.Qu;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.mapper.QuMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.xm.Similarity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目相似度计算
 */
public class QuSimilarityCompute {
    /**
     * 重建redis存储的题目相似度列表
     *
     * @param stringRedisTemplate
     * @return
     */
    public Boolean rebuildAllQuSimilarity(StringRedisTemplate stringRedisTemplate, QuMapper quMapper) {

        // 遍历所有题目
        QuQuery quQuery = new QuQuery();
        List<Qu> quList = quMapper.selectList(quQuery);
        HashMap<String, Double> map1 = new LinkedHashMap<>();
        if (quList != null && !quList.isEmpty()) {
            for (Qu qu : quList) {
                // 遍历其他题目和这个的题目的相似度
                for (Qu other : quList) {
                    double morphoSimilarityResult =
                            Similarity.morphoSimilarity(qu.getContent(), other.getContent());
                    map1.put(other.getId(), morphoSimilarityResult);
                }

            }

            map1.entrySet()
                    .stream().sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> map1.put(x.getKey(), x.getValue()));
        }

        return null;
    }
}
