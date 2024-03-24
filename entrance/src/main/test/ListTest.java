import cn.hutool.core.collection.ListUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ListTest {
    @Test
    public void test(){
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);

        ArrayList<Integer> list3 = new ArrayList<>();

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);
        boolean a = list1.containsAll(list2);
        boolean b = list1.containsAll(list3);
        boolean c = list1.containsAll(list4);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
