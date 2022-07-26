package ink.starfish.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * flux
 *
 * @author: starfish
 * @date: 2022/7/26 13:36
 **/
public class FluxDemo {
    public static void main(String[] args) throws InterruptedException {
        print("运行...");

        // 同步线程，在main线程中执行
       Flux.just("A", "B", "C")
                .subscribe(FluxDemo::print);

        // 线程切换
        Flux.just("E", "D", "F")
                //.publishOn(Schedulers.elastic())
                .map(s -> "*" + s)
                .subscribe(
                        /* 数据消费 = onNext*/
                        FluxDemo::print,
                        /* 异常处理 = onError(Throwable)，若抛异常，onComplete不会执行了 */
                        FluxDemo::print,
                        /* 完成回调 = onComplete()*/
                        () -> print("done."),
                        /* 背压操作 onSubscribe(Subscription)*/
                        subscription -> {
                            /*请求的元素数量*/
                            subscription.request(2);
                            /*取消上游传输数据到下游*/
                            subscription.cancel();
                        }
                );

        print("main done.");
    }

    private static void print(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程：" + threadName + "] " + object);
    }

}
