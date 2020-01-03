package stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: Stream API
 * @author: starfish
 * @create: 2020-01-02 18:49
 **/
public class StreamTest {


    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()    //将流转化为并行流
                .reduce(0L, Long::sum);

    }

}
