package ink.starfish.reactive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 阻塞数据加载器
 * @autoor: starfish
 * @date: 2022/7/25 20:30
 **/
public class FutureBlockingDataLoader extends DataLoader {

    protected void doLoad() {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池
        runCompletely(executorService.submit(super::loadConfigurations));  //  耗时 >= 1s
        runCompletely(executorService.submit(super::loadUsers));           //  耗时 >= 2s
        runCompletely(executorService.submit(super::loadOrders));          //  耗时 >= 3s
        executorService.shutdown();
    } // 总耗时 sum(>= 1s, >= 2s, >= 3s)  >= 6s

    private void runCompletely(Future<?> future) {
        try {
            future.get(); // 阻塞等待结果执行
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }

}
