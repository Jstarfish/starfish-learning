package strategy;

/**
 * @description:
 * @author: starfish
 * @date: 2021/4/16 16:02
 */
public class Context {

    //持有一个具体的策略对象
    private Strategy strategy;

    //构造方法，传入具体的策略对象
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void doSomething(){
        //调用具体的策略对象进操作
        strategy.operate();
    }
}
