package gc;

/**
 * @description:
 * @author: starfish
 * @data: 2020-04-01 15:50
 **/
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==hello gc===");

        //Thread.sleep(Integer.MAX_VALUE);

        //-Xms10m -Xmx10m -XX:PrintGCDetails

        byte[] bytes = new byte[11 * 1024 * 1024];

    }
}
