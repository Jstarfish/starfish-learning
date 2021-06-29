package pipeline.stage;

import lombok.val;
import org.apache.commons.io.FileUtils;
import pipeline.handler.Pipeline;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: starfish
 * @date: 2021/5/25 19:58
 */
public class ClientTest {

    public static void main(String[] args) {

        File file = new File("/Users/apple/Documents/hello.txt");


        StoppablePipeline pipeline = new StoppablePipeline<>();

        val actuator = pipeline.addStage(new FileProcessHandler())
                .addStage(new CharacterFilterHandler())
                .addStage(new CharacterReverseHandler());

        actuator.execute(file);


    }
}
