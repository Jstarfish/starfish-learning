package pipeline.handler;

import lombok.val;

/**
 * @description: Pipeline that will gather and execute the handlers one by one
 * @author: starfish
 * @date: 2021/5/25 19:53
 */
public class Pipeline<I, O> {

    private final Handler<I, O> currentHandler;

    Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    <K> Pipeline<I, K> addStage(Handler<O, K> newHandler) {
        return new Pipeline<>(input -> {
            val o = currentHandler.process(input);
            return o != null ? newHandler.process(o) : null;
        });
    }

    O execute(I input) {
        return currentHandler.process(input);
    }
}
