package priv.starfish.concurrent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: jiahaixin
 * @date: 2019/8/6 10:31
 * @description:
 */
public class TestDealListByThreadPlus {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        int threadNum = 20;//线程数数量
        List<String> taskList = new ArrayList<String>();
        for (int i = 0; i < 566; i++) {
            taskList.add("任务执行结果为:" + i + "-----");
        }

        Date startDate = new Date();
        AtomicInteger index = new AtomicInteger();
        index.set(0);
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new ListWokerPlus(taskList, index);

            thread.setName("线程" + i);
            service.execute(thread);
        }

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.HOURS);
            Date endDate = new Date();
            System.out.println("本次处理耗时:" + String.valueOf(endDate.getTime() - startDate.getTime()) + "ms");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
