package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-04 15:08
 **/
public class SynchronousQueueDemo {


    public static void main(String[] args) {


        BlockingQueue<String> queue = new SynchronousQueue<>();

        //System.out.println(queue.offer("aaa"));   //false
        //System.out.println(queue.poll());         //null

        System.out.println(queue.add("bbb"));        //ava.lang.IllegalStateException: Queue full

        new Thread(()->{
            try {
                System.out.println("Thread 1 put a");
                queue.put("a");

                System.out.println("Thread 1 put b");
                queue.put("b");

                System.out.println("Thread 1 put c");
                queue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Thread 2 get:"+queue.take());

                TimeUnit.SECONDS.sleep(2);
                System.out.println("Thread 2 get:"+queue.take());

                TimeUnit.SECONDS.sleep(2);
                System.out.println("Thread 2 get:"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
