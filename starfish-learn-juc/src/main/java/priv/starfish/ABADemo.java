package priv.starfish;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference
 **/
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    static AtomicStampedReference<Integer> asf = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {


        // ABA 问题的产生

        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicReference.compareAndSet(100, 200));
        },"t2").start();


        //最后结果是200，但是线程t1中间有改过 atomicReference 的值， 如何解决呢

        //======  ABA 问题的解决

        new Thread(()->{
            int stamp = asf.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+stamp);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asf.compareAndSet(100,101,asf.getStamp(),asf.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"\t 第二次版本号："+asf.getStamp());

            asf.compareAndSet(101,100,asf.getStamp(),asf.getStamp() + 1);

            System.out.println(Thread.currentThread().getName()+"\t 第三次版本号："+asf.getStamp());
        },"t3").start();


        new Thread(()->{
            int stamp = asf.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号："+stamp);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = asf.compareAndSet(100,200,asf.getStamp(),asf.getStamp() + 1);


            System.out.println(Thread.currentThread().getName()+"\t 是否修改成功" + result);
            System.out.println(Thread.currentThread().getName()+"\t 当前实际版本号：" + asf.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 当前实际最新值：" + asf.getReference());


        },"t4").start();


    }
}
