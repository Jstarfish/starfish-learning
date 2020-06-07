package adapter.demo;

/**
 * @description: 被适配的类
 * @author: starfish
 * @data: 2020-06-07 13:30
 **/
public class Volatage220V {

    public final int output = 220;

    public int output220v() {
        System.out.println("输出电压 " + output);
        return output;
    }
}
