package priv.starfish.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: jiahaixin
 * @date: 2019/8/6 10:49
 * @description:
 */
public class CurrentHandleList {


    public static void main(String[] args) throws InterruptedException {

        int threadNum = 100;
        ExecutorService service = Executors.newFixedThreadPool(threadNum);

        // 准备数据
        LinkedList<String> data = new LinkedList<String>();
        for (int i = 0; i < 10000; i++) {
            data.add("item" + "  " + i);
        }

        int length = data.size();
        //int tl = length % threadNum == 0 ? length / threadNum : (length / threadNum + 1);
        int tl = 1000;
        CountDownLatch latch = new CountDownLatch(threadNum);// 多少协作
        long a = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            int end = (i + 1) * tl;
            RunnableThread thread = new RunnableThread("线程[" + (i + 1) + "] ", data, i * tl, end > length ? length : end, latch);
            service.submit(thread);
        }

        //latch.await();
        System.out.println("结束*****************************");
        long b = System.currentTimeMillis();
        System.out.println("时间:" + (b - a) + "毫秒***********************");
        service.shutdown();
    }


    // 实现Runnable
    static class RunnableThread implements Runnable {

        private String threadName;
        private List<String> data;
        private int start;
        private int end;
        private CountDownLatch latch;

        public RunnableThread(String threadName, List<String> data, int start, int end, CountDownLatch latch) {
            this.threadName = threadName;
            this.data = data;
            this.start = start;
            this.end = end;
            this.latch = latch;
        }

        public void run() {
            // TODO 这里处理数据
            List<String> l = data.subList(start, end);
            System.out.println(threadName + "--" + data.size() + "--" + start + "--" + end + "--");
            for (int i = 0; i < l.size(); i++) {
                // 单个线程中的数据
                System.out.println(l.get(i));
            }
            latch.countDown();// 计数器减一
        }
    }


}
