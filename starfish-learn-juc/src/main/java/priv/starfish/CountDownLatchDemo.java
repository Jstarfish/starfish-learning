package priv.starfish;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-04 09:33
 **/
public class CountDownLatchDemo {

    final static int studentsNum = 10;

    //模拟下晚自习，班长最后关门
    public static void main(String[] args) throws InterruptedException {

        //closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_country(i).getRetMessage()).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName()+"\t 秦国统一六国");


    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(studentsNum);

        //i<10 会死循环？
        //for (int i = 1; i < 10; i++) {
        for (int i = 1; i <= 10; i++) {

                new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");

                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长锁门，离开教室");
    }

}
