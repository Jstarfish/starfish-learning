package memory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-21 21:41
 **/
public class HeapSpaceInitial {

    public static void main(String[] args) {

        //返回 JVM 堆大小
        long initalMemory = Runtime.getRuntime().totalMemory() / 1024 /1024;

        //返回 JVM 堆的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 /1024;

        System.out.println("-Xms : "+initalMemory + "M");
        System.out.println("-Xmx : "+maxMemory + "M");

        System.out.println("系统内存大小：" + initalMemory * 64 / 1024 + "G");

        System.out.println("系统内存大小：" + maxMemory * 4 / 1024 + "G");

    }
}
