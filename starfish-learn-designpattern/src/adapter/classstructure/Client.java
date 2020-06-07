package adapter.classstructure;

/**
 * @description:
 * @author: starfish
 * @data: 2020-06-07 11:52
 **/
public class Client {
    public static void main(String[] args) {
//        Target target = new ConcreteTarget();
//        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }


}
