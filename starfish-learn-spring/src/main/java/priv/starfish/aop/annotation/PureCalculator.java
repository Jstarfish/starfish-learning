package priv.starfish.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/22 20:40
 */
@Component
public class PureCalculator implements ICalculator {

    public int add(int i, int j) {
        return  i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i*j;
    }

    public int div(int i, int j) {
        return i/j;
    }
}
