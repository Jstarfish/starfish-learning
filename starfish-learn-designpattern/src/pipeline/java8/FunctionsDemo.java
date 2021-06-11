package pipeline.java8;

import java.util.function.Function;

/**
 * @description: java8
 * @author: starfish
 * @date: 2021/5/25 20:31
 */
public class FunctionsDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> addOne = it -> {
            System.out.println(it + 1);
            return it + 1;
        };

        Function<Integer, Integer> addTwo = it -> {
            System.out.println(it + 2);
            return it + 2;
        };

        Function<Integer, Integer> timesTwo = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                System.out.println(input * 2);
                return input * 2;
            }
        };

        final Function<Integer, Integer> pipe = addOne
                .andThen(timesTwo)
                .andThen(addTwo);

        pipe.apply(10);
    }




}
