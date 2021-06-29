package pipeline.stage;

/**
 * @description:
 * @author: starfish
 * @date: 2021/6/24 11:50
 */
public class TwoStage implements StoppablePipeline.Stage<String,String> {
    @Override
    public String process(String input) {
        return "aaa";
    }
}
