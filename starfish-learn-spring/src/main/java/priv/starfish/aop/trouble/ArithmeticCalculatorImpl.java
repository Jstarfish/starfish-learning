package priv.starfish.aop.trouble;

/**
 * @description: 计算器实现类
 * @author: starfish
 * @date: 2021/7/13 16:24
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator{

    public void add(int i, int j) {
//        if(i < 0 || j < 0){
//            throw new IllegalArgumentException("Positive numbers only");
//        }
//        System.out.println("The method add begins with " + i + "," + j);
        int result =  i + j;
        System.out.println("result: "+ result);
//        System.out.println("The method add ends with " + i + "," + j);
    }

    public void sub(int i, int j) {
//        if(i < 0 || j < 0){
//            throw new IllegalArgumentException("Positive numbers only");
//        }
//        System.out.println("The method sub begins with " + i + "," + j);
        int result =  i - j;
        System.out.println("result: "+ result);
//        System.out.println("The method sub ends with " + i + "," + j);
    }
}
