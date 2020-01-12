package others;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: Java8 接口中的默认方法
 * @author: starfish
 * @create: 2020-01-03 14:59
 **/
public class TestDefaultMethod {

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(22,11,33,55,4);


        //sort是List接口中的默认方法,naturalOrder是Comparator的静态方法
        list.sort(Comparator.naturalOrder());

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
