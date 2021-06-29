package pipeline.stage;

import pipeline.handler.Handler;

/**
 * @description: 字符翻转
 * @author: starfish
 * @date: 2021/5/26 15:30
 */
public class CharacterReverseHandler implements StoppablePipeline.Stage<String, String>{

    @Override
    public String process(String input) {
        //Handler.chekInput(input);

        if(Handler.checkInput(input)){
            return null;
        }
        System.out.println("===反转字符串===");
        return new StringBuilder(input).reverse().toString();
    }
}
