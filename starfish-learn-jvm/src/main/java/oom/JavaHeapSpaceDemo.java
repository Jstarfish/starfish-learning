package oom;

/**
 * @description: 堆内存溢出, JVM参数：-Xmx12m
 * @author: starfish
 * @data: 2020-05-05 15:55
 **/
public class JavaHeapSpaceDemo {

    static final int SIZE = 2 * 1024 * 1024;

    public static void main(String[] a) {
        int[] i = new int[SIZE];
    }
}
