package priv.starfish.proxypattern.jdkproxydemo;

/**
 * @author: jiahaixin
 * @date: 2019/6/21 11:39
 * @description:
 */
public class RealSubject implements Subject {
    @Override
    public int sellBooks() {
        System.out.println("sell books...");
        return 1;
    }

    @Override
    public String speak() {
        System.out.println("please speak...");
        return "狗子";
    }
}
