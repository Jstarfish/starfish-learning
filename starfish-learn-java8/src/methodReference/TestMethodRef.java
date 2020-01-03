package methodReference;

import lambda.Person;
import org.junit.Test;

import java.io.PrintStream;
import java.time.chrono.IsoChronology;
import java.util.Comparator;
import java.util.function.*;

/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 * 注意：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 *
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * 1. 类名 :: new
 *
 * 三、数组引用
 * 	类型[] :: new;
 *
 */
public class TestMethodRef {

//    private static Person get() {
//        return new Person("Tom", IsoChronology.INSTANCE.date(1995, 6, 20), Person.Sex.MALE, "tom@qq.com");
//    }

    @Test
    public void arrayRef() {

    }


    @Test
    public void test1() {
        PrintStream ps = System.out;
        Consumer<String> con = str -> ps.println(str);
        con.accept("java8 nb");

        System.out.println("===等价于===");

        Consumer<String> con1 = ps::println;
        con1.accept("java8 nb");

        System.out.println("===等价于===");
        Consumer<String> con2 = System.out::println;
        con1.accept("java8 nb");
    }


   // 特定对象的实例方法引用
    @Test
    public void test2() {
        Person person = new Person("Tom", IsoChronology.INSTANCE.date(1995, 6, 20), Person.Sex.MALE, "tom@qq.com");

        Supplier<String> sup = () -> person.getName();
        System.out.println(sup.get());

        System.out.println("===等价于===");

        Supplier<String> sup1 = person::getName;
        System.out.println(sup1.get());
    }

    @Test
    public void test3(){
        BiFunction<Double,Double,Double> bif = (x,y)->Math.max(x,y);
        System.out.println(bif.apply(22.1,23.2));

        System.out.println("===等价于===");

        BiFunction<Double,Double,Double> bif1 = Math::max;
        System.out.println(bif1.apply(22.1,23.2));
    }

    @Test
    public void test4(){
        Comparator<Integer> com = (x, y)->Integer.compare(x,y);
        System.out.println(com.compare(1,2));

        System.out.println("===等价于===");
        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(1,2));
    }

    //类名 :: 实例方法名
    @Test
    public void test5(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        System.out.println(bp.test("Java情报局","Java情报局1"));
        System.out.println("===等价于===");

        BiPredicate<String,String> bp1 = String::equals;
        System.out.println(bp.test("Java情报局","Java情报局"));
    }


    //构造器
    @Test
    public void test6(){
        Supplier<Person> sup = ()->new Person("Tom", IsoChronology.INSTANCE.date(1995, 6, 20), Person.Sex.MALE, "tom@qq.com");
        System.out.println(sup.get());
        System.out.println("===等价于===");

//        Consumer<Person> sup1 = Person::new;
//        Person p = sup1.accept(p.);
//        sup1.accept();
//        System.out.println(sup1.get());
    }

    //数组引用
    @Test
    public void test7(){
        Function<Integer,String[]> fun = args -> new String[args];
        String[] strs = fun.apply(6);
        System.out.println(strs.length);

        System.out.println("===等价于===");
        Function<Integer,String[]> fun1 = String[]::new;
        String[] strs1 = fun1.apply(6);
        System.out.println(strs1.length);
    }


}
