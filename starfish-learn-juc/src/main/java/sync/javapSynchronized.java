package sync;

/**
 * @description:对象锁（monitor）机制
 * @author: starfish
 * @create: 2020-04-10 17:48
 **/
public class javapSynchronized {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }

}
