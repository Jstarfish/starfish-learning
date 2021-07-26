package priv.starfish.aop.trouble;

/**
 * @description: 客户端
 * @author: starfish
 * @date: 2021/7/14 10:08
 */
public class Client {

    public static void main(String[] args) {

        ValidationHandler validationHandler = new ValidationHandler();
        LoggingHandler loggingHandler = new LoggingHandler();

        //cglib 要求目标对象是个单独的对象
        ArithmeticCalculatorImpl calculatorImpl = new ArithmeticCalculatorImpl();
        validationHandler.createProxy(calculatorImpl);

        //JDK 动态代理要求目标对象实现一个接口
        ArithmeticCalculator calculator = new ArithmeticCalculatorImpl();
        ArithmeticCalculator loggingProxy = (ArithmeticCalculator) loggingHandler.createProxy(calculator);
        loggingProxy.add(1,2);

        ArithmeticCalculatorImpl validationProxy = (ArithmeticCalculatorImpl) validationHandler.createProxy(calculatorImpl);
        validationProxy.sub(-1,2);
    }
}
