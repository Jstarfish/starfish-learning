package priv.example;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * @description:
 * @author: starfish
 * @create: 2020-07-27 14:09
 */
public class Test {


    public static final Properties props = new Properties();
    final String topic = "dmp_product_local";

    static {
        props.put("bootstrap.servers", "10.208.251.93:39092");
        props.put("acks", "-1");//
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }


    final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);


}
