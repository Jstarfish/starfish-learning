package reference;

import javafx.beans.binding.ObjectExpression;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @description:
 * @author: starfish
 * @create: 2020-05-08 13:29
 **/
public class ReferenceQueueDemo {


    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        WeakReference<Object> weakReference = new WeakReference<Object>(referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        o1 = null;
        System.gc();
        Thread.sleep(3000);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        //ThreadLocal
    }



}
