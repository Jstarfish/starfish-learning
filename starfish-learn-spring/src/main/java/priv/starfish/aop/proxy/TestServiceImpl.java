package priv.starfish.aop.proxy;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/13 11:21
 */
public class TestServiceImpl implements TestService {
    public int test() {
        System.out.println("开始执行test...");
        return 0;
    }
}
