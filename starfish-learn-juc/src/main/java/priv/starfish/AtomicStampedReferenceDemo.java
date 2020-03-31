package priv.starfish;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: starfish
 * @create: 2020-03-31 13:02
 **/
public class AtomicStampedReferenceDemo {

    static AtomicStampedReference<String> asf = new AtomicStampedReference<>("A", 1);

    public static void main(String[] args) {

        new Thread(() -> {
            String value = asf.getReference();
            System.out.println("Thread1 current value: " + asf.getReference() + ", stamp: " + asf.getStamp());

            asf.compareAndSet(value, "B", asf.getStamp(), asf.getStamp() + 1);
            System.out.println("Thread1： " + value + "——>" + asf.getReference() + ",stamp:" + asf.getStamp());
            value = asf.getReference();
            asf.compareAndSet(asf.getReference(), "A", asf.getStamp(), asf.getStamp() + 1);
            System.out.println("Thread1： " + value + "——>" + asf.getReference() + ",stamp:" + asf.getStamp());
        }).start();

        new Thread(() -> {
            String value = asf.getReference();

            int stamp = asf.getStamp();
            System.out.println("Thread2 current value: " + asf.getReference() + ", stamp: " + stamp);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2: " + value + "——>" + "B" + ",stamp:" + stamp + 1);
            boolean flag = asf.compareAndSet(value, "B", stamp, stamp + 1);
            if (flag) {
                System.out.println("Thread 2 update from " + value + " to B");
            } else {
                System.out.println("Thread 2 update fail");
            }
        }).start();
    }
}

