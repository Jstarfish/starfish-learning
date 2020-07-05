package memory;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-21 20:33
 **/
public class HeadDemo {
    public static void main(String[] args) {
        System.out.println("start ...");
        try {
            Thread.sleep(500000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
