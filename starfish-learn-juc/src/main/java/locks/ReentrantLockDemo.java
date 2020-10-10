package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-03 13:36
 **/
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sendMSM();

        },"t1").start();


        new Thread(()->{
            phone.sendMSM();

        },"t2").start();


        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();
    }
}

class Phone implements Runnable{

    public synchronized void sendMSM(){
        System.out.println(Thread.currentThread().getName()+"\t send msm");
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\t send email");
    }

    //------

    Lock lock = new ReentrantLock();

    @Override
    public void run(){
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke get");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke set");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}