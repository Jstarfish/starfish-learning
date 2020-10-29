package loopthread;

/**
 * @description: 数字和字母交替打印 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
 * @author: starfish
 * @create: 2020-10-28 17:41
 */
public class NumAndLetterPrinter {
    private static char c = 'A';
    private static int i = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> printer(), "numThread").start();
        new Thread(() -> printer(), "letterThread").start();
    }

    private static void printer() {
        synchronized (lock) {
            for (int i = 0; i < 26; i++) {
                if (Thread.currentThread().getName() == "numThread") {
                    //打印数字1-26
                    System.out.print((i + 1));
                    // 唤醒其他在等待的线程
                    lock.notifyAll();
                    try {
                        // 让当前线程释放锁资源，进入wait状态
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (Thread.currentThread().getName() == "letterThread") {
                    // 打印字母A-Z
                    System.out.print((char) ('A' + i));
                    // 唤醒其他在等待的线程
                    lock.notifyAll();
                    try {
                        // 让当前线程释放锁资源，进入wait状态
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notifyAll();
        }
    }



}
