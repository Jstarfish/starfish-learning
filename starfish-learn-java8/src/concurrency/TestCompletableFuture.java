package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @description: CompletableFuture
 * @author: starfish
 * @create: 2020-01-13 14:29
 **/
public class TestCompletableFuture {

    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        ArrayList<String> resultList = new ArrayList<>();
        CompletableFuture[] completableFutures1 = list.stream().map(s -> CompletableFuture.supplyAsync(() -> {
                            System.out.println("supplyAsync执行开始。。。。。");
                            if (s.equals("c") || s.equals("b")) {
                                try {
                                    Thread.sleep(1000 * 10);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("supplyAsync执行完成。。。。。");
                            return s + "-one";
                        })
                        .thenApply(s2 -> s2.toUpperCase())
                        .whenComplete((str, thr) -> {
                            if (thr == null) {
                                System.out.println("whenComplete执行start...，str=" + str);
                                str = str + "-two";
                                System.out.println("whenComplete执行end...，str=" + str);
                                resultList.add(str);
                            } else {
                                System.err.println("发生异常，s=" + s);
                            }

                        }).exceptionally(s3 -> {
                            System.out.println("执行失败。。。。。。。。。。");
                            return null;
                        })

        ).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures1).join();
        System.out.println("最后结果："+resultList);

    }



}
