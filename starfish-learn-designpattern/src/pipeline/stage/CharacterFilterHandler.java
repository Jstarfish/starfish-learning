package pipeline.stage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 字符过滤
 * @author: starfish
 * @date: 2021/5/26 15:00
 */
public class CharacterFilterHandler implements StoppablePipeline.Stage<String,String>{

    @Override
    public String process(String input) {
        System.out.println("===字符过滤===");
        List<String> hello = Stream.of(input).filter(s -> s.contains("hello")).collect(Collectors.toList());
        return String.join("",hello);
        //return null;
    }

}
