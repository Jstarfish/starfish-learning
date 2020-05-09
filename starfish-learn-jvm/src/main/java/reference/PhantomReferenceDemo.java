package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @description:
 * @author: starfish
 * @create: 2020-05-08 13:38
 **/
public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(phantomReference.get());

        o1 = null;
        System.gc();
        Thread.sleep(3000);

        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(phantomReference.get());
    }

}
