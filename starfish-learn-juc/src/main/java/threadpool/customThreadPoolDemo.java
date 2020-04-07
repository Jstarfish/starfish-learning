package threadpool;

import java.util.concurrent.*;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-04 21:24
 **/
public class customThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService threads = new ThreadPoolExecutor(2,
                5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // new ThreadPoolExecutor.AbortPolicy());


        try {

            for (int i = 0; i < 13; i++) {
                threads.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threads.shutdown();
        }

    }
}
