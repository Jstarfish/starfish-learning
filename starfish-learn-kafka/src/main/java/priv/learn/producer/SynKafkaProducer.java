package priv.learn.producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
/**
 * @description: 同步方式
 * @author: starfish
 * @create: 2020-08-03 17:32
 */
public class SynKafkaProducer {

    public static final Properties props = new Properties();

    static {
        props.put("bootstrap.servers", "10.202.253.240:9092");
        //props.put("bootstrap.servers", "10.208.251.93:39092");
        // 0:producer不会等待broker发送ack
        // 1:当leader接收到消息后发送ack
        // -1:当所有的follower都同步消息成功后发送ack
        props.put("acks", "-1");//
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    final KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);

    private String topicName;

    public SynKafkaProducer(String topicName) {
        this.topicName = topicName;
    }

    public RecordMetadata send(String key, String value) {
        RecordMetadata recordMetadata = null;
        try {
            recordMetadata = kafkaProducer.send(new ProducerRecord<String, String>(topicName,
                    key, value)).get();//get方法将阻塞，直到返回结果RecordMetadata
        } catch (InterruptedException e) {
            //进行日志记录或者异常处理
        } catch (ExecutionException e) {
            //进行日志记录或者异常处理
        }
        return recordMetadata;
    }

    public void close() {
        if (kafkaProducer != null) {
            kafkaProducer.close();
        }
    }

    public static void main(String[] args) {
        SynKafkaProducer synKafkaProducer = new SynKafkaProducer("test");
        for (int i = 0; i < 10; i++) {
            RecordMetadata metadata = synKafkaProducer.send(String.valueOf(i), "This is " + i +
                    " message");
            System.out.println("TopicName : " + metadata.topic() + " Partiton : " + metadata
                    .partition() + " Offset : " + metadata.offset());
        }
        synKafkaProducer.close();
    }


}
