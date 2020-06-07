package adapter.demo;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-07 13:32
 **/
public class VoltageAdapter implements IVoltage5V {

    private Volatage220V volatage220V;  //聚合

    public VoltageAdapter(Volatage220V v) {
        this.volatage220V = v;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != volatage220V) {
            int src = volatage220V.output220v();
            System.out.println("适配器工作~~~~~");
            dst = src / 44;
            System.out.println("适配器工作完成，输出电压" + dst);
        }
        return dst;
    }
}
