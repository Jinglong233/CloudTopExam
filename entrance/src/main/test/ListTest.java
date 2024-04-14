import cn.hutool.core.collection.ListUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.xm.Similarity;

import java.util.ArrayList;

@SpringBootTest
public class ListTest {
    @Test
    public void test(){
        String sentence1 = "老师办理教师资格证";
        String sentence2 = "监理工程师资格证书";//"电脑病毒是有害的吗";

        double morphoSimilarityResult = Similarity.morphoSimilarity(sentence1, sentence2);
        double editDistanceResult = Similarity.editDistanceSimilarity(sentence1, sentence2);
        double standEditDistanceResult = Similarity.standardEditDistanceSimilarity(sentence1,sentence2);
        double gregeorEditDistanceResult = Similarity.gregorEditDistanceSimilarity(sentence1,sentence2);

        System.out.println(sentence1 + " vs " + sentence2 + " 词形词序句子相似度值：" + morphoSimilarityResult);
        System.out.println(sentence1 + " vs " + sentence2 + " 优化的编辑距离句子相似度值：" + editDistanceResult);
        System.out.println(sentence1 + " vs " + sentence2 + " 标准编辑距离句子相似度值：" + standEditDistanceResult);
        System.out.println(sentence1 + " vs " + sentence2 + " gregeor编辑距离句子相似度值：" + gregeorEditDistanceResult);

    }
}
