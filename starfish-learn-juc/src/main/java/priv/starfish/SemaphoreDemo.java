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

        //模拟 3 个车位
        Semaphore semaphore = new Semaphore(3);

        //7 辆车去争抢
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();  //抢到车位
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 停车 3 秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                System.out.println(Thread.currentThread().getName()+"\t抢到车位");
            },String.valueOf(i)).start();
        }
    }
}
