package priv.starfish.aop.annotation;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/22 20:41
 */
public class MaxCalculatorImpl implements IMaxCalculator {
    public int max(int i, int j) {
        System.out.println("execute max method ...");
        return Math.max(i, j);
    }
}
