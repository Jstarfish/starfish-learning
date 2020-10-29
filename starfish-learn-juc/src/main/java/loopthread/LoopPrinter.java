package loopthread;

import java.util.concurrent.Semaphore;

/**
 * @description: N个线程循环打印1-100
 * @author: starfish
 * @create: 2020-10-28 16:31
 */
public class LoopPrinter {

    private final static int THREAD_COUNT = 3;
    static int result = 0;
    static int maxNum = 10;

    public static void main(String[] args) throws InterruptedException {
        final Semaphore[] semaphores = new Semaphore[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            //非公平信号量，每个信号量初始计数都为1
            semaphores[i] = new Semaphore(1);
            if (i != THREAD_COUNT - 1) {
                System.out.println(i+"==="+semaphores[i].getQueueLength());
                //获取一个许可前线程将一直阻塞, for 循环之后只有 syncObjects[2] 没有被阻塞
                semaphores[i].acquire();
            }
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            // 初次执行，上一个信号量是 syncObjects[2]
            final Semaphore lastSemphore = i == 0 ? semaphores[THREAD_COUNT - 1] : semaphores[i - 1];
            final Semaphore currentSemphore = semaphores[i];
            final int index = i;
             new Thread(() -> {
                try {
                    while (true) {
                        // 初次执行，让第一个 for 循环没有阻塞的 syncObjects[2] 先获得令牌阻塞了
                        lastSemphore.acquire();
                        System.out.println("thread" + index + ": " + result++);
                        if (result > maxNum) {
                            System.exit(0);
                        }
                        // 释放当前的信号量，syncObjects[0] 信号量此时为 1，下次 for 循环中上一个信号量即为syncObjects[0]
                        currentSemphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
