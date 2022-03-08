package others;

import org.junit.Assert;
import scala.collection.mutable.SynchronizedMap;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: starfish
 * @create: 2020-06-28 17:28
 **/
public class Test {

    private static Pattern NUMBER_PATTERN = Pattern.compile("([1-9]+[0-9]*|0)(\\.[\\d]+)?");


    public static void main(String[] args) {

        if(23==23 | 1!=1){
            System.out.println(1);
        }

        if(23!=23 | 1==1){
            System.out.println(3);
        }

        if(23!=23 || 1==1){
            System.out.println(4);
        }

        int i = 0;

        if(23!=23 | 1==1){
            System.out.print("结果为真"+i);

        }else {
            System.out.print("结果为假" + i);
        }




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
