package priv.example;

/**
 * @author: jiahaixin
 * @date: 2019/9/11 11:09
 * @description: kafka的一些配置信息，
 */
public class KafkaProperties {

    public static final String TOPIC = "topic1";
    public static final String KAFKA_SERVER_URL = "10.121.214.96";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;
    public static final String TOPIC2 = "topic2";
    public static final String TOPIC3 = "topic3";
    public static final String CLIENT_ID = "SimpleConsumerDemoClient";

    private KafkaProperties() {
    }
}
