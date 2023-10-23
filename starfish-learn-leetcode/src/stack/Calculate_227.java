package stack;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 *
 * @author: starfish
 * @date: 2023/10/21 17:16
 **/
public class Calculate_227 {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int num = 0;
        char preSign = '+';
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(s.charAt(i))) {
                // 转为 int
                num = num * 10 + (s.charAt(i) - '0');
            }
            // 计算符 （排除空格）
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == length - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
