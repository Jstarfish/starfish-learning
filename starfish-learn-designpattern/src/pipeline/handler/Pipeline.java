package pipeline.handler;

import org.junit.Assert;

/**
 * @description: Pipeline that will gather and execute the handlers one by one
 * @author: starfish
 * @date: 2021/5/25 19:53
 */
public class Pipeline<I,O> {

    private final Handler<I,O> currentHandler;

    Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

     <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
        return new Pipeline<>(new Handler<I, K>() {
            @Override
            public K process(I input) {
                System.out.println(input.toString());
                Assert.assertNotNull(input);
                return newHandler.process(currentHandler.process(input));
            }
        });
    }

    O execute(I input) {
        return currentHandler.process(input);
    }
}
