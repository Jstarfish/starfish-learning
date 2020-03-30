package responsibility;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-29 09:24
 **/
public class Client {

    public static void main(String[] args) {
        ConcreteHandler1 handler1 = new ConcreteHandler1(1);
        ConcreteHandler2 handler2 = new ConcreteHandler2(2);
        ConcreteHandler3 handler3 = new ConcreteHandler3(3);

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        handler1.handlerRequest(new Request(1));


    }
}
