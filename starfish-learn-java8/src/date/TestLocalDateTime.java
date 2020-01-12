package date;


import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @description:
 * @author: starfish
 * @create: 2020-01-03 18:45
 **/
public class TestLocalDateTime {


    //LocalDate、LocalTime、LocalDateTime(LocalDate和LocalTime的合体)
    @Test
    public void test1(){
        LocalDate date = LocalDate.of(2020,01,03);
        Month month = date.getMonth();
        System.out.println(month);    //JANUARY

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);   //FRIDAY

        int len = date.lengthOfMonth();
        System.out.println(len);  //31
        //使用TemporalField(ChronoField枚举实现了该接口）读取LocalDate的值
        int year = date.get(ChronoField.YEAR);
        System.out.println(year);  //2020

        LocalDate ld = LocalDate.parse("2020-01-03");
        System.out.println(ld);   //2020-01-03

        LocalTime time = LocalTime.of(19,56,11);
        System.out.println(time);  //19:56:11

        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime l1 = LocalDateTime.of(2020,01,03,18,48);
        System.out.println(l1);  //2020-01-03T18:48

        LocalDateTime l2 = l1.plusYears(3);
        System.out.println(l2);     //2023-01-03T18:48

        LocalDateTime l3 = l1.minusMonths(1);
        System.out.println(l3);  //2019-12-03T18:48
        System.out.println(l3.getMinute()+","+l3.getYear());   //48,2019
    }


    //2. Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
    @Test
    public void test2(){
        Instant ins = Instant.now();  //默认使用 UTC 时区
        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
        System.out.println(ins.getNano());
        Instant ins2 = Instant.ofEpochSecond(5);
        System.out.println(ins2);
    }


    @Test
    public void test3(){
        Instant ins1 = Instant.now();

        System.out.println("--------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Instant ins2 = Instant.now();

        System.out.println("所耗费时间为：" + Duration.between(ins1, ins2));   //所耗费时间为：PT1.001S

        System.out.println("----------------------------------");

        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2019, 1, 1);

        Period pe = Period.between(ld2, ld1);
        System.out.println(pe.getYears());
        System.out.println(pe.getMonths());
        System.out.println(pe.getDays());
    }


    //5. DateTimeFormatter : 解析和格式化日期或时间
    @Test
    public void test4(){
//		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date = LocalDate.now();
        //通过withAttributer方法修改LocalDate的属性
        LocalDate date1 = date.with(ChronoField.ALIGNED_WEEK_OF_YEAR,9);
        LocalDate date2 = date.withYear(2019);
        LocalDate date3 = date.withDayOfMonth(11);  //修改为11号
        System.out.println(date1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);

        System.out.println(strDate); //2020年01月03日 20:32:14 星期五

        LocalDateTime newLdt = ldt.parse(strDate, dtf);
        System.out.println(newLdt);  //2020-01-03T20:32:14
    }


    //6.ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
    @Test
    public void test7(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);
    }

    @Test
    public void test6(){
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }




    //4. TemporalAdjuster : 时间校正器
    @Test
    public void test41(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义：下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;

            DayOfWeek dow = ldt4.getDayOfWeek();

            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);
            }
        });

        System.out.println(ldt5);

    }

    //3.
    //Duration : 用于计算两个“时间”间隔
    //Period : 用于计算两个“日期”间隔








}
