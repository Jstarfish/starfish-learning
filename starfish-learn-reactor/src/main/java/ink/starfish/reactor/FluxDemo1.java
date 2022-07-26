package ink.starfish.reactor;

import reactor.core.publisher.Flux;

/**
 * TODO
 *
 * @author: starfish
 * @date: 2022/7/26 13:38
 **/
public class FluxDemo1 {
    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(() -> 0,
                (v, sink) -> {
                    sink.next("value: " + v);
                    if (v == 10) {
                        sink.complete();
                    }
                    return v + 1;
                });

        flux.subscribe(FluxDemo1::print);

        Flux.range(0, 10).handle((item, sink) -> {
            if (item % 2 == 0) {
                sink.next("Even: " + item);
            }
        }).subscribe(FluxDemo1::print);
    }

    private static void print(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程：" + threadName + "] " + object);
    }

}
