package others;

import org.junit.Assert;

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

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 6);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = df.format(calendar.getTime());

        System.out.println(startTime);



        final BigDecimal PLAN_PRICE_MAX_VAL = new BigDecimal(999.99);
        System.out.println(PLAN_PRICE_MAX_VAL.toPlainString());


        System.out.println(NUMBER_PATTERN.matcher("33.22").matches());

        int a = 1;
        for (int i = 0; i < 10; i++) {

            if(5>a){
                if(a>0){
                    System.out.println("dddd");
                }
                if(2>a){
                    System.out.println("cccc");
                }

                System.out.println("aaa");
            }


            if(true){
                System.out.println("---");
            }
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
