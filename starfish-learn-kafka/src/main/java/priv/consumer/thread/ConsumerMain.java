package priv.consumer.thread;

/**
 * @description: 多线程消费的2种方式
 * @author: starfish
 * @create: 2020-08-18 10:59
 */
public class ConsumerMain {

    public static void main(String[] args) {
        String brokerList = "localhost:9092";
        String groupId = "testGroup1";
        String topic = "test-topic";
        int consumerNum = 3;

        ConsumerGroup consumerGroup = new ConsumerGroup(consumerNum, groupId, topic, brokerList);
        consumerGroup.execute();
    }


    /**
     * worker 的方式
     * @param args
     */
//    public static void main(String[] args) {
//        String brokerList = "localhost:9092,localhost:9093,localhost:9094";
//        String groupId = "group2";
//        String topic = "test-topic";
//        int workerNum = 5;
//
//        ConsumerHandler consumers = new ConsumerHandler(brokerList, groupId, topic);
//        consumers.execute(workerNum);
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException ignored) {}
//        consumers.shutdown();
//    }

}
