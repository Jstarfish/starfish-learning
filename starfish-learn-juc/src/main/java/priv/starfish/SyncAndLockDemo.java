package priv.starfish;

/**
 *
 *  synchronized 和 Lock 有什么区别，用 Lock 有什么好处
 *
 *   1. synchronized 是 Java 关键字，属于 JVM 层面
 *      monitorenter(底层是monitorenter对象来完成的，其实 wait/notify 等方法也是依赖与 monitorenter
 *      对象，只有在同步块或方法中才能调用 wati/notify等方法)
 *
 *      Lock是具体类，API层面的
 *
 *   2. synchronized 不需要手动释放，lock需要手动释放
 *
 *   3.等待是否可中断
 *      synchronized不可中断
 *      ReentrontLock 可中断
 *   4. synchronized 默认非公平锁，ReentrontLock 构造器可构造公平锁
 *
 *   5. 锁绑定多个条件condition，synchronized没有
 *      ReentrontLock 用来实现分组唤醒需要唤醒的线程，可精准唤醒，不像 synchronized要么随机唤醒一个线程要么全部唤醒
 */


import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程按顺序调用，A->B->C
 * AA 打印 5 次，BB 打印10 次，CC 打印 15 次
 */
public class SyncAndLockDemo {

    public static void main(String[] args) {
        ShareData data = new ShareData();

        new Thread(()->{
            data.print5();
        },"A").start();

        new Thread(()->{
            data.print10();
        },"B").start();

        new Thread(()->{
            data.print15();
        },"C").start();


    }
}

class ShareData{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

public void print5(){
    lock.lock();
    try {

        //1.判断
        while (num != 1){
            c1.await();
        }

        //2.干活
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i);
        }

        //3.通知
        num = 2;
        c2.signal();

    }catch (InterruptedException e) {
        e.printStackTrace();
    }finally {
        lock.unlock();
    }
    }

    public void print10(){
        lock.lock();
        try {

            //1.判断
            while (num != 2){
                c2.await();
            }

            //2.干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            //3.通知
            num = 3;
            c3.signal();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {

            //1.判断
            while (num != 3){
                c3.await();
            }

            //2.干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            //3.通知
            num = 1;
            c1.signal();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
