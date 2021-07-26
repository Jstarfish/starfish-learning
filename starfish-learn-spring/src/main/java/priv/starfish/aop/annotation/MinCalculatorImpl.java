package priv.starfish.aop.annotation;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/22 20:41
 */
public class MinCalculatorImpl implements IMinCalculator {
    public int min(int i, int j) {
        System.out.println("execute min method ...");
        return Math.min(i, j);
    }
}
