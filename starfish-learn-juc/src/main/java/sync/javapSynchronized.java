package sync;

/**
 * @description:对象锁（monitor）机制
 * @author: starfish
 * @create: 2020-04-10 17:48
 **/
public class javapSynchronized {

    private final Object lock = new Object();

    private static int money = 0;

    //非静态方法
    public synchronized void noStaticMethod(){
        money ++;
    }

    //静态方法
    public static void staticMethod(){
        money ++;
    }

    public void codeBlock(){
        //代码块
        synchronized (lock){
            money ++;
        }
    }

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }

}
