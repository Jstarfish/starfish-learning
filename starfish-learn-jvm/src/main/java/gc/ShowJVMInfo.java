package gc;

/**
 * @description: 程序中查看JVM参数
 * @author: starfish
 * @data: 2020-05-05 11:41
 **/
public class ShowJVMInfo {

    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("total_memory(-xms)="+totalMemory+"字节，" +(totalMemory/(double)1024/1024)+"MB");
        System.out.println("max_memory(-xmx)="+maxMemory+"字节，" +(maxMemory/(double)1024/1024)+"MB");

    }
}
