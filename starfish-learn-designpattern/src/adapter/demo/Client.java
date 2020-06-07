package adapter.demo;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-07 13:33
 **/
public class Client {



    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Volatage220V()));
    }
}
