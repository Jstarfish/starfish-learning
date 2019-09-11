package priv.learn.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author: jiahaixin
 * @date: 2019/9/9 17:12
 * @description: 增加时间拦截器，在发送消息时增加时间
 */
public class TimeInterceptor implements ProducerInterceptor<String, String> {
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        // 创建一个新的 record，把时间戳写入消息体的最前部
        return new ProducerRecord(producerRecord.topic(), producerRecord.partition(),
                producerRecord.timestamp(), producerRecord.key(),
                System.currentTimeMillis() + "," + producerRecord.value().toString());
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
