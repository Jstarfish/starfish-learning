package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Array Arrays
 *  Collection Collections
 *  Executor Executors
 *
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        //5 个业务员处理业务
        //ExecutorService threads = Executors.newFixedThreadPool(5);

        //只有一个业务员
        //ExecutorService threads = Executors.newSingleThreadExecutor();

        // 多个业务员
        ExecutorService threads = Executors.newWorkStealingPool();


        //模拟 10 个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {

            for (int i = 0; i < 10; i++) {
                threads.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        }catch (Exception e){

        }finally {
            threads.shutdown();
        }


    }
}
