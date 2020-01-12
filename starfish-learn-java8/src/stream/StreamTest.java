package stream;

import lambda.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: Stream API
 * @author: starfish
 * @create: 2020-01-02 18:49
 **/
public class StreamTest {


    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()    //将流转化为并行流
                .reduce(0L, Long::sum);

    }


    //1. 创建 Stream
    @Test
    public void test1(){
        //1. Collection 提供了两个方法  stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);

        //4. 创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        //生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);

    }

    //2. 中间操作
    List<Person> persons = Person.createRoster();

	/*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

    //内部迭代：迭代操作 Stream API 内部完成
    @Test
    public void test2(){
        //所有的中间操作不会做任何的处理
        Stream<Person> stream = persons.stream()
                .filter((e) -> {
                    System.out.println("测试中间操作");
                    return e.getAge() <= 35;
                });

        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test3(){
        Iterator<Person> it = persons.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void test4(){
        persons.stream()
                .filter((p) -> {
                    System.out.println("大于25岁的成员："); // &&  ||
                    return (p.getAge()) >= 25;
                }).limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void test5(){
        persons.parallelStream()
                .filter((e) -> e.getAge() >= 20)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test6(){
        persons.stream()
                .distinct()
                .forEach(System.out::println);
    }

}
