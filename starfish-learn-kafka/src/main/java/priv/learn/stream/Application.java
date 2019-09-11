package priv.learn.stream;
import java.util.Properties;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.processor.TopologyBuilder;

/**
 * @author: jiahaixin
 * @date: 2019/9/9 17:46
 * @description:
 */
public class Application {

    public static void main(String[] args) {
        // 定义输入的 topic
        String from = "first";
        // 定义输出的 topic
        String to = "second";
        // 设置参数
        Properties settings = new Properties();
        settings.put(StreamsConfig.APPLICATION_ID_CONFIG, "logFilter");
        settings.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop102:9092");
        StreamsConfig config = new StreamsConfig(settings);
        // 构建拓扑
        TopologyBuilder builder = new TopologyBuilder();
        builder.addSource("SOURCE", from)
                .addProcessor("PROCESS", new ProcessorSupplier<byte[], byte[]>() {
                    @Override
                    public Processor<byte[], byte[]> get() {
// 具体分析处理
                        return new LogProcessor();
                    }
                }, "SOURCE")
                .addSink("SINK", to, "PROCESS");
        // 创建 kafka stream
        KafkaStreams streams = new KafkaStreams(builder, config);
        streams.start();
    }
}
