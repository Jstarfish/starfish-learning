package queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 题目：一个初始值为 0 的变量，两个线程对齐交替操作，一个+1，一个-1，5 轮
 */
public class ProdCounsume_BlockQueueDemo {
    public static void main(String[] args) {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(3));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");

            try {
                resource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");

            try {
                resource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consume").start();

        System.out.println();
        System.out.println();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("5秒钟以后，main 线程叫停");
        resource.stop();

    }

}


class MyResource{
    private volatile boolean flag = true;  //默认开启，进行生产+消费

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> queue = null;

    //高手不会写死，写通用的可扩展的，且往往是传接口，不会传具体的类
    public MyResource(BlockingQueue<String> queue) {
        this.queue = queue;
        System.out.println(queue.getClass().getName());
    }

    public void myProd() throws InterruptedException {
        String data = null;
        boolean value;
        while (flag){
            data = atomicInteger.incrementAndGet()+"";
            value = queue.offer(data,2, TimeUnit.SECONDS);
            if(value){
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"success");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"fail");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName()+"\t 叫停，表示flag=false,生产动作结束");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while (flag){
            result = queue.poll(2,TimeUnit.SECONDS);

            if(null == result || result.equalsIgnoreCase("")){
                flag = false;
                System.out.println("超过 2 秒没有取到，消费退出");
                System.out.println();
                return;
            }

            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }
    }

    public void stop(){
        this.flag =false;
    }
}


