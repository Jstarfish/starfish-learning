package loopthread;

import java.util.ArrayList;
import java.util.concurrent.locks.LockSupport;

/**
 * @description: 数字和字母交替打印 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
 * @author: starfish
 * @create: 2020-10-28 17:41
 */
public class NumAndLetterPrinter2 {

    private static Thread numThread, letterThread;

    public static void main(String[] args) {
        letterThread = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                LockSupport.unpark(numThread);
                LockSupport.park();
            }
        }, "letterThread");

        numThread = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.park();
                LockSupport.unpark(letterThread);
            }
        }, "numThread");
        numThread.start();
        letterThread.start();
    }
}
