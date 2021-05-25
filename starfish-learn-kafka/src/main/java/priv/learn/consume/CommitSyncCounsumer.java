package priv.learn.consume;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import priv.example.Consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author: jiahaixin
 * @date: 2019/10/10 16:33
 * @description: 同步手动提交offset
 */
public class CommitSyncCounsumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        //props.put("bootstrap.servers", "qa.broker1.log.kafka.biz.sogou:9092,qa.broker3.log.kafka.biz.sogou:9092,qa.broker3.log.kafka.biz.sogou:9092");
        //props.put("bootstrap.servers", "10.139.20.58:9092,10.139.36.108:9092,10.139.36.110:9092");
        props.put("bootstrap.servers", "10.160.20.161:9092,10.160.22.146:9092,10.160.23.212:9092");
        props.put("bootstrap.servers", "broker1.kafka.biz.sogou:9092,broker2.kafka.biz.sogou:9092,broker3.kafka.biz.sogou:9092,broker4.kafka.biz.sogou:9092,broker5.kafka.biz.sogou:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "newgroup-2");

        //关闭自动提交offset
        //props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset","latest");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");


        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        //consumer.seekToEnd();
        consumer.subscribe(Arrays.asList("ielog_sku_audit", "second", "third", "learn-java-kafka"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n",
                        record.offset(), record.key(), record.value());
            }
            //需要自己手动提交
            consumer.commitSync();
        }
    }
}
