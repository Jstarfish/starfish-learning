package priv.learn.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.*;


/**
 * @author: jiahaixin
 * @date: 2019/9/9 16:03
 * @description:
 */
public class ProducerDemo {

    public static void main(String[] args) {

        Properties properties = new Properties();
        // Kafka 服务端的主机名和端口号
        properties.put("bootstrap.servers", "10.160.20.161:9092,10.160.22.146:9092,10.160.23.212:9092");
        //properties.put("bootstrap.servers", "qa.broker1.log.kafka.biz.sogou:9092,qa.broker3.log.kafka.biz.sogou:9092,qa.broker3.log.kafka.biz.sogou:9092 ");
        // 等待所有副本节点的应答
        properties.put("acks", "all");
        // 消息发送最大尝试次数
        properties.put("retries", 0);
        // 一批消息处理大小
        properties.put("batch.size", 16384);
        // 请求延时
        properties.put("linger.ms", 1);
        // 发送缓存区内存大小
        properties.put("buffer.memory", 33554432);
        // key 序列化
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value 序列化
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("ielog_sku",
                    Integer.toString(i), "hello world-" + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        System.out.println("TopicName : " + recordMetadata.topic() + " Partiton : " + recordMetadata
                                .partition() + " Offset : " + recordMetadata.offset());
                    } else {
                        //进行异常处理
                    }
                }
            });
        }
        producer.close();
    }
}
