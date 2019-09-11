/*
package priv.learn.producer;

import java.util.Properties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


*/
/**
 * @author: jiahaixin
 * @date: 2019/9/9 15:34
 * @description: 创建生产者（过时的 API）
 *//*

public class OldProducer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("metadata.broker.list","10.121.214.96:9092");
        properties.put("request.required.acks", "1");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");

        Producer<Integer, String> producer = new Producer<Integer,String>(new
                ProducerConfig(properties));
        KeyedMessage<Integer, String> message = new KeyedMessage<Integer,
                String>("test-java-kafka", "hello world java kafka");
        producer.send(message );

    }
}
*/
