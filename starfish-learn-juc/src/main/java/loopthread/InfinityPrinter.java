package loopthread;

/**
 * @description: 一个多线程的问题，用五个线程，顺序打印数字1~无穷大，其中每5个数字为1组，如下：其中id代表线程的id
 * <p>
 * id   1   2   3   4   5
 * no   1   2   3   4   5
 * no   6   7   8   9   10
 * no   11  12  13  14  15
 * no   ..  ..  ..  ..  ..
 */
public class InfinityPrinter {

    private static volatile int orderNum = 1;// 必要的时候声明为volatile类型的

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        while (true) {
                            if (orderNum % 5 == threadId || orderNum % 5 == 0) {
                                if (orderNum % 5 == 0)
                                    System.out.println("threadid = " + 5 + " " + orderNum++);
                                else
                                    System.out.println("threadid = " + threadId + " " + orderNum++);
                                Thread.sleep(1000);// 为了执行效果看的更清楚
                                notifyAll();
                            } else {
                                wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(r, "1");
        Thread t2 = new Thread(r, "2");
        Thread t3 = new Thread(r, "3");
        Thread t4 = new Thread(r, "4");
        Thread t5 = new Thread(r, "5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
