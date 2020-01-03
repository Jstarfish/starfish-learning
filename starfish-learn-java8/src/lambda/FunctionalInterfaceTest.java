package lambda;

import org.junit.Test;

import javax.lang.model.type.NullType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/*
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class FunctionalInterfaceTest {

    //Predicate<T> 断言型接口：将满足条件的字符串放入集合
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                newList.add(s);
            }
        }
        return newList;
    }

    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("hello", "java8", "function", "predicate");
        List<String> newList = filterStr(list, s -> s.length() > 5);
        for (String s : newList) {
            System.out.println(s);
        }
    }

    // Function<T, R> 函数型接口：处理字符串
    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    @Test
    public void testFunction() {
        String str1 = strHandler("测试内置函数式接口", s -> s.substring(2));
        System.out.println(str1);

        String str2 = strHandler("abcdefg", s -> s.toUpperCase());
        System.out.println(str2);
    }

    //Supplier<T> 供给型接口 :产生指定个数的整数，并放入集合
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void testSupplier() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    //Consumer<T> 消费型接口 :修改参数
    public void modifyValue(Integer value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }

    @Test
    public void testConsumer() {
        modifyValue(3, s -> System.out.println(s * 3));
    }

    public static void main(String[] args) {

        BinaryOperator<Double> binaryOperator = (x,y)->Math.pow(x,y);

        BinaryOperator<Double> binaryOperator1 = Math::pow;

        //Function<,Person> fun = () -> new Person(); ;

    }


}
