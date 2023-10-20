package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * <p>
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * tokens = ["4","13","5","/","+"]
 *
 * @author: starfish
 * @date: 2023/10/20 10:01
 **/
public class EvalRPN_150 {

    public int evalRPN(String[] tokens) {
        List<String> charts = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!charts.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.peek();
    }
}
