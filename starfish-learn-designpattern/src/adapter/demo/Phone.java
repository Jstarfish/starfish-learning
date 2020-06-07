package adapter.demo;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-07 12:28
 **/
public class Phone {

    public void charging(IVoltage5V v) {
        if (v.output5V() == 5) {
            System.out.println("电压 5V ，符合充电标准，开始充电");
        } else {
            System.out.println("电压不符合标准，无法充电");
        }
    }
}
