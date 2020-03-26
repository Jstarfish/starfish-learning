package priv.starfish;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是什么：
 * 比较并交换
 **/
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger num = new AtomicInteger(6);

        System.out.println(num.compareAndSet(6, 7) + "\t + current num:" + num);

        System.out.println(num.compareAndSet(6, 8) + "\t current num:" + num);
    }
}
