package methodReference;

import org.junit.Test;
import sun.util.resources.LocaleData;

import javax.xml.transform.Templates;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @description: Java8提供的新的日期类
 * @author: starfish
 * @create: 2019-12-31 16:42
 **/
public class TestDate {

    @Test
    public void test1(){
        LocalDate nextSunday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);
    }

}


interface MyFunc<T> {

    static void show(){
        System.out.println("hello JavaEgg");
    }
    default String getName() {
        return "hello java8";
    }
}

interface MyFunc1 {
    default String getName() {
        return "hello Java情报局";
    }
}

class MyClass implements MyFunc, MyFunc1 {

    @Override
    public String getName() {
        return MyFunc1.super.getName();
    }
}