package pipeline.handler;

/**
 * @description: The stages of our pipeline are called Handlers.
 * @author: starfish
 * @date: 2021/5/25 19:41
 */
public interface Handler<I,O> {
    /**
     * @param input
     * @return
     */
    O process(I input);

    static boolean checkInput(String input){
        return input == null;
    }

}
