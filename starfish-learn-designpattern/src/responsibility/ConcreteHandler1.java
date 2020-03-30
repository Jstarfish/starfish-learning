package responsibility;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-29 09:22
 **/
public class ConcreteHandler1 extends Handler {
    public ConcreteHandler1(int level) {
        super(level);
    }

    @Override
    public void response(Request request) {
        System.out.println("请求由处理器1进行处理");
    }
}
