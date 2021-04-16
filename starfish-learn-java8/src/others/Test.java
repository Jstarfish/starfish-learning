package others;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: starfish
 * @create: 2020-06-28 17:28
 **/
public class Test {


    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "C", "D");

        for (String s : list) {
            if(s.equals("C")){
                System.out.println(s);
                return;
            }
        }
        //System.out.println(list.stream().filter(i -> i.equals("C")).findFirst().orElse(null));

        //getResult(null);

    }

    private static ConditionInfoDto getExistCondition(List<ConditionInfoDto> conditionInfoList, ConditionInfo cond) {
        return conditionInfoList.stream().filter(i->i.getField().equals(cond.getField())).findFirst().orElse(null);
    }

    public static Integer getResult(Integer i){

        AtomicInteger a = new AtomicInteger(0);
        Integer b = 10;

        for (int i1 = 0; i1 < 100; i1++) {
            a.addAndGet(1);
        }



        System.out.println(a.get());

        System.out.println(a.addAndGet(b));
        return a.addAndGet(b);

    }
}
