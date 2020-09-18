package recursion;

import java.util.HashMap;

/**
 * @description: 斐波那契数列
 * 斐波那契数列的是这样一个数列：1、1、2、3、5、8、13、21、34....，即第一项 f(1) = 1,第二项 f(2) = 1.....,第 n 项目为 f(n) = f(n-1) + f(n-2)。求第 n 项的值是多少。
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 *  
 * 提示：
 * 0 <= n <= 100
 */
public class Fibonacci {

    // 暴力递归法
//    public int fib(int n) {
//        if (n < 2)
//            return n;
//        return fib(n - 1) + fib(n - 2);
//    }

    // 记忆递归法
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        } else {
            int result = fib(n - 1) + fib(n - 2);
            hashMap.put(n, result);
            return result;
        }
    }

    public static int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        //用一个数组充当备忘录，保存记录
        int[] dp = new int[n + 1];
        //初始值
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //动态规划
    public static int fib3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int result = 0, pre = 1, next = 2;
        for (int i = 3; i < n + 1; i++) {
            result = pre + next;
            pre = next;
            next = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib2(4));

    }



}
