package sync;

/**
 * @description: 对象锁和类锁
 * @author: starfish
 * @create: 2020-07-16 15:57
 **/
public class SynchronizedClassDemo {

//    public static void main(String[] args) {
//        synchronized (SynchronizedDemo.class) {
//        }
//        method();
//    }
//
//    private synchronized static void method() {
//    }

//    public void method() {
//        synchronized (this) {
//            System.out.println("Method 1 start");
//        }
//    }

    public synchronized void method() {
        System.out.println("Hello World!");
    }

}
