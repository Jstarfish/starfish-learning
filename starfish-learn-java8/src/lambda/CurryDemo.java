package lambda;

import java.util.function.Function;

/**
 * 级联表达式
 *
 * 珂里化：把多个参数的函数转换为只有一个参数的函数
 * 珂里化的目的：函数标准化
 * 高阶函数：返回函数的函数
 *
 * @author: starfish
 * @date: 2022/8/24 15:41
 **/
public class CurryDemo {

    public static void main(String[] args) {
        //实现了 x+y 的级联表达式
        //珂里化：把多个参数的函数转换为只有一个参数的函数
        Function<Integer,Function<Integer,Integer>> fun = x ->y -> x + y;

        System.out.println(fun.apply(2).apply(3));
    }
}
