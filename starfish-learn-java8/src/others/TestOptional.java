package others;

import lambda.Person;
import org.junit.Test;

import java.time.chrono.IsoChronology;
import java.util.Optional;
import java.util.concurrent.*;

/**
 * @description:
 * @author: starfish
 * @create: 2020-01-03 16:13
 **/
public class TestOptional {

    @Test
    public void test1() {
        Optional<Person> op = Optional.of(new Person());
        Person person = op.get();
        System.out.println(person);
    }

    @Test
    public void test2() {
        Person person = null;
        Optional<Person> op = Optional.of(person);
        Person p = op.get();      //java.lang.NullPointerException
        // System.out.println(p);
    }


    @Test
    public void test() {

        Optional<Person> optional = Optional.empty();  //创建一个空Optional

        Optional<Person> op = Optional.of(new Person());
        Person p = op.get();
        System.out.println(p);   //Person{name='null', birthday=null, gender=null, emailAddress='null'}

        Person person = null;
        Optional<Person> op1 = Optional.of(person); //person为null，抛出NullPointerException

        Optional<Person> op2 = Optional.ofNullable(person);   //创建允许null值得Optional对象

    }


    @Test
    public void test4() {
        Optional<Person> op = Optional.of(new Person("Tom", IsoChronology.INSTANCE.date(1999, 7, 15), Person.Sex.FEMALE, "Tom@360.com"));

        /*
         * 使用 map 从 optional 对象中提取和转换值
         * 如果想提取人员姓名，之前需要判断persion !=null,Optional提供了一个map方法，对其处理
         */
        Optional<String> op2 = op.map(Person::getName);
        System.out.println(op2.get());

        //使用 flatMap 链接 optional 对象
        Optional<String> op3 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(op3.get());
    }


    @Test
    public void test3() {
        Optional<Person> op = Optional.ofNullable(new Person());

        if (op.isPresent()) {
            System.out.println(op.get());
        }

        Person p = op.orElse(new Person("Tom", IsoChronology.INSTANCE.date(1999, 7, 15), Person.Sex.FEMALE, "Tom@360.com"));
        System.out.println(p);

        Person p1 = op.orElseGet(() -> new Person());
        System.out.println(p1);
    }


    public void test7() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            public Double call() {
                return 1.1;
               // return doSomeThings();    //异步方式在新的线程中执行操作
            }
        });
        //doSomethingElse();    //异步操作进行的同时，可以做其他事情
        try {
            Double result = future.get(1, TimeUnit.SECONDS);   //获取异步操作的结果，如果阻塞，等1秒后退出
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
        }
    }


}
