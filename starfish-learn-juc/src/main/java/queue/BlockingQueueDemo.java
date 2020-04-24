package queue;

import java.util.concurrent.*;

/**
 * @description:
 *
 *  ArrayBlockingQueue, 一个基于数组结构的有界阻塞队列，次队列按 FIFO(先进先出)原则对元素进行排序
 *  DelayQueue,
 *  LinkedBlockingDeque,
 *  LinkedBlockingQueue, 一个基于链表结构的阻塞队列，次队列按 FIFO(先进先出)排序元素，吞吐量要高于ArrayBlockingQueue
 *  LinkedTransferQueue,
 *  PriorityBlockingQueue,
 *  SynchronousQueue, 一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，
 **/
public class BlockingQueueDemo {


    public static void main(String[] args) {


        /**
         * 异常组
         */

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        //LinkedBlockingQueue

        System.out.println(queue.add("a"));   //true
        System.out.println(queue.remainingCapacity());
        System.out.println(queue.add("b"));    //true
       // System.out.println(queue.add("c"));   //java.lang.IllegalStateException: Queue full

        System.out.println(queue.element());  //a

        //System.out.println(queue.element());  //a


        //System.out.println(queue.remove());  //a
       // System.out.println(queue.remove());   //b
        //System.out.println(queue.remove());  // java.util.NoSuchElementException

        System.out.println("------------");
        /**
         * 布尔值组
         */
        BlockingQueue<String> queue1 = new ArrayBlockingQueue<>(2);
        System.out.println(queue1.offer("a"));  //true
        System.out.println(queue1.offer("b"));  //true
        System.out.println(queue1.offer("c"));   //false

        System.out.println(queue1.peek()+"22222");   //a

        System.out.println(queue1.poll());     //a
        System.out.println(queue1.poll());     //b
        System.out.println(queue1.poll());     //null

        System.out.println("------------");

        /**
         * 阻塞
         */
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(2);
        try {
            queue2.put("a");
            queue2.put("b");
            System.out.println("=======");
            //queue2.put("c");


            System.out.println(queue2.take());   //a
            System.out.println(queue2.take());   //b
            //System.out.println(queue2.take());  //阻塞一直等待

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 超时控制,等一会插不进去或取不出来就撤了
         */
        BlockingQueue<String> queue3 = new ArrayBlockingQueue<>(2);
        try {
            System.out.println(queue3.offer("a",2,TimeUnit.SECONDS));   //true
            System.out.println(queue3.offer("b", 2, TimeUnit.SECONDS));  //true
            System.out.println(queue3.offer("c", 2, TimeUnit.SECONDS));   //false


            System.out.println(queue3.poll(2,TimeUnit.SECONDS));    //a
            System.out.println(queue3.poll(2,TimeUnit.SECONDS));    //b
            System.out.println(queue3.poll(2,TimeUnit.SECONDS));  //null,阻塞2秒后退出

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
