package reference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @description: 虚引用
 * @author: starfish
 * @data: 2020-05-06 22:02
 **/
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> w1 = new WeakReference<Object>(o1);

        System.out.println(o1);
        System.out.println(w1.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(w1.get());


    }
}
