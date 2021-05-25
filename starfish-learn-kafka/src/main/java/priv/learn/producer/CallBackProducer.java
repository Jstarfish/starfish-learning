package priv.learn.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @author: jiahaixin
 * @date: 2019/9/9 16:11
 * @description: 异步发送：创建生产者带回调函数（新 API）
 */
public class CallBackProducer {

    public static void main(String[] args) {

        Properties props = new Properties();
        // Kafka 服务端的主机名和端口号
        //props.put("bootstrap.servers", "10.160.20.161:9092,10.160.22.146:9092,10.160.23.212:9092");
        props.put("bootstrap.servers", "10.139.20.58:9092,10.139.36.108:9092,10.139.36.110:9092");
        // 等待所有副本节点的应答
        props.put("acks", "all");
        // 消息发送最大尝试次数
        props.put("retries", 0);
        // 一批消息处理大小
        props.put("batch.size", 16384);
        // 增加服务端请求延时
        props.put("linger.ms", 1);
        // 发送缓存区内存大小
        props.put("buffer.memory", 33554432);
        // key 序列化
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        // value 序列化
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);
        for (int i = 0; i < 50; i++) {
            kafkaProducer.send(new ProducerRecord<String, String>("learn-java-kafka", "key", "hello"
                    + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception
                        exception) {
                    if (metadata != null) {
                        System.err.println(metadata.partition() + "---" +
                                metadata.offset());
                    }
                }
            });
        }
        kafkaProducer.close();
    }
}