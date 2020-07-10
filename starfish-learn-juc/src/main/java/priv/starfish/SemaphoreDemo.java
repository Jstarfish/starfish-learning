package priv.starfish;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: 模拟抢车位
 * @author: starfish
 * @data: 2020-04-04 10:29
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {

        //模拟 5 张桌子
        Semaphore semaphore = new Semaphore(5,true);

        //7 波吃饭的客人
        for (int i = 1; i <= 7 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 进去吃饭");
                    TimeUnit.SECONDS.sleep(3);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"\t 吃完离开");
                    semaphore.release();
                }
                //System.out.println(Thread.currentThread().getName()+"\t抢到车位");
            },String.valueOf(i)).start();
        }
    }
}
