package loopthread;

import java.util.concurrent.locks.Lock;

/**
 * @description: 使用wait/notify 实现三个线程 打印ABC
 * @author: starfish
 * @create: 2020-10-26 18:40
 */
public class PrintABCUsingWaitNotify {

    private int state;
    private int times;
    private static final Object LOCK = new Object();

    public PrintABCUsingWaitNotify(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABC = new PrintABCUsingWaitNotify(10);
        new Thread(() -> {
            printABC.printLetter("A", 0);
        }, "A").start();
        new Thread(() -> {
            printABC.printLetter("B", 1);
        }, "B").start();
        new Thread(() -> {
            printABC.printLetter("C", 2);
        }, "C").start();
    }

    private void printLetter(String name, int targetState) {
        for (int i = 0; i < times; i++) {
            synchronized (LOCK) {

                while (state % 3 != targetState) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.print(name);
                LOCK.notifyAll();
            }
        }
    }
}