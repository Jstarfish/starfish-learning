package priv.starfish.demo;


import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/22 17:15
 */
public class Test {

    public static void main(String[] args) {
        //Assert.isTrue(100<1,"dd");

        System.out.println(Optional.ofNullable("demo").orElse("a")); //demo
        System.out.println(Optional.ofNullable(null).orElse("a")); //a
        //或者 使用supplier生产
        System.out.println(Optional.ofNullable(null).orElseGet(() -> "abc")); //abc

        final Long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final Long endTime = System.currentTimeMillis();
        Long cost = endTime - startTime;
        System.out.println("kylin查询耗时: " + cost + " ms");

            String a = "hello2";
            final String b = "hello";
            String d = "hello";
            String c = b + 2;
            String e = d + 2;
            System.out.println((a == c));
            System.out.println((a == e));

        System.out.println(a.equals(c));
        System.out.println(a.equals(e));
    }
}
