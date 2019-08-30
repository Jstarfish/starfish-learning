package priv.starfish.other;

/**
 * @author: jiahaixin
 * @date: 2019/7/26 15:00
 * @description:
 */
public class TestBreakAndContinue {


    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            System.out.println("i的值是" + i);
            if (i == 1) {
                break;
            }
            System.out.println("continue后的输出语句");

        }
    }
}
