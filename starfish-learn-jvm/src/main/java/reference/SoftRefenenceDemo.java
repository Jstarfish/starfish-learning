package reference;

import java.lang.ref.SoftReference;

/**
 * 软引用
 */
public class SoftRefenenceDemo {

    public static void main(String[] args) {
        softRefMemoryEnough();
        System.out.println("-------");
        softRefMemoryNotEnough();

    }

    private static void softRefMemoryEnough() {
        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(s1.get());

        o1 = null;

        System.gc();

        System.out.println(o1);
        System.out.println(s1.get());
    }


    /**
     * JVM配置`-Xms5m -Xmx5m` ，然后故意new一个一个大对象，使内存不足产生 OOM，看软引用回收情况
     */
    private static void softRefMemoryNotEnough() {
        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(s1.get());

        o1 = null;

        byte[] bytes = new byte[10 * 1024 * 1024];

        System.out.println(o1);
        System.out.println(s1.get());
    }
}
