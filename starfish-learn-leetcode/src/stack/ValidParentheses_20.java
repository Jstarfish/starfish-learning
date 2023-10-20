package stack;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        int n = s.length();

        if (n / 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        if(s.isEmpty()) {
            return true;
        }
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(') {
                stack.push(')');
            } else if(c=='{') {
                stack.push('}');
            } else if(c=='[') {
                stack.push(']');
            } else if(stack.empty()||c!=stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00%");
        System.out.println(decimalFormat.format((double)1/3));

        String s = "()";
        System.out.println(isValid_5(s));


    }
    
    public static boolean isValid_5(String s){
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
