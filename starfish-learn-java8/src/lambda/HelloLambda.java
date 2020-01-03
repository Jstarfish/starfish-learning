package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @description:
 * @author: starfish
 * @create: 2019-12-26 18:09
 **/
public class HelloLambda {

    //匿名内部类
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("hello runnable");
        }
    };

    //Lambda表达式
    Runnable runnable1 = () -> System.out.println("hello lambda");


    //使用匿名内部类作为参数
    TreeSet<String> list = new TreeSet<String>(new Comparator<String>(){

        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(),o2.length());
        }
    });

    //Lambda表达式作为参数
    TreeSet<String> list1 = new TreeSet<String>((o1, o2) -> Integer.compare(o1.length(),o2.length()));


    //Lambda表达式的各种写法
    Consumer<String> consumer = (args) -> System.out.println(args);

    Consumer<String> consumer1 = args -> System.out.println(args);

    BinaryOperator<Long> binaryOperator = (x,y) -> {
        System.out.println("实现函数接口方法");
        return x +y;
    };


    BinaryOperator<Long> binaryOperator1 = (x, y) -> x + y;


    public static String toUpperString(MyFunc<String> myFunc, String str) {
        return myFunc.getValue(str);
    }

    public static void main(String[] args) {
        String newStr = toUpperString((str) -> str.toUpperCase(), "abc");
        System.out.println(newStr);

        List<Integer> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


    }
}
