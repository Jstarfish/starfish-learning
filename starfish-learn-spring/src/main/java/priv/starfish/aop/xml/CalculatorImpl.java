package priv.starfish.aop.xml;

import org.springframework.stereotype.Service;

/**
 * @description: 计算器实现类
 * @author: starfish
 * @date: 2021/7/13 16:24
 */
public class CalculatorImpl implements Calculator {

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
