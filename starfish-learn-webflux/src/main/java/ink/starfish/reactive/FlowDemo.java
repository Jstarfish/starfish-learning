package ink.starfish.reactive;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class FlowDemo {

    public static void main(String[] args) throws Exception {
        // 1. 定义发布者，发布的数据类型是Integer
        SubmissionPublisher<Integer> publiser = new SubmissionPublisher<Integer>();

        // 2. 定义订阅者
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                // 保存订阅关系，需要用它来给发布者响应
                this.subscription = subscription;

                // 请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                // 接收到一个数据，处理
                System.out.println("接收到数据 " + item);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 处理完调用request,再请求一个
                this.subscription.request(1);

                // 如果已经达到目标，调用cancel取消
                // this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
                // 异常
                throwable.printStackTrace();

                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("��������!");
            }

        };

        // 3. 发布者和订阅者建立订阅关系
        publiser.subscribe(subscriber);

        // 4. 生产数据并发布
        // 这里忽略数据生产过程
        for (int i = 0; i < 1000; i++) {
            System.out.println("生产数据:" + i);
            // submit�Ǹ�block����
            publiser.submit(i);
        }

        // 5.结束后，关闭发布者
        publiser.close();

        // 主线程延迟停止，否则数据没有消费就退出
        Thread.currentThread().join(1000);

        System.out.println();
    }

}
