package ink.starfish.reactive;

import java.util.concurrent.CompletableFuture;

/**
 * 链式数据加载器
 *
 * @autoor: starfish
 * @date: 2022/7/25 20:40
 **/
public class FutureChainDataLoader extends DataLoader {

    protected void doLoad() {
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> { // 完成时回调
                    System.out.println("加载完成");
                })
                .join(); // 等待完成
    }

    public static void main(String[] args) {
        new FutureChainDataLoader().load();
    }
}
