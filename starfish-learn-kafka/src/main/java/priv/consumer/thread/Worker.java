package priv.consumer.thread;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @description:
 * @author: starfish
 * @create: 2020-08-18 10:59
 */
public class Worker implements Runnable {

    private ConsumerRecord<String, String> consumerRecord;

    public Worker(ConsumerRecord record) {
        this.consumerRecord = record;
    }

    @Override
    public void run() {
        // 这里写你的消息处理逻辑，本例中只是简单地打印消息
        System.out.println(Thread.currentThread().getName() + " consumed " + consumerRecord.partition()
                + "th message with offset: " + consumerRecord.offset());
    }
}
