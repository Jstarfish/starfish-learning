package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *
 * 手写一个自旋锁
 *
 * 通过 CAS 操作完成自旋锁，A 线程先进来调用myLock 方法自己持有锁 5 秒
 * B 线程随后进来发现当前有线程持有锁，不是 null,所以只能通过自旋等待，
 * 知道A 释放锁后B 随后抢到
 **/
public class SpinLockDemo {

    AtomicReference<Thread> lock = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + "\t get  lock");
        //如果不为空，自旋
        while (! lock.compareAndSet(null,thread)){

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t unlock");
        //解锁后，将锁置为 null
        lock.compareAndSet(thread,null);
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{

            spinLockDemo.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            spinLockDemo.myUnlock();

        },"t1").start();

        new Thread(()->{
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();

        },"t2").start();
    }


}
