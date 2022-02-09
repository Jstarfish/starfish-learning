package dp;

/**
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs_70 {

/*    public static int climb(int n){
        int dp[] = new int[n];    为什么是 n+1
        dp[1] = 1;
        for(int i = 2;i<n;i++){
            dp[i] = dp[i-1] +1;
        }
        return dp[n];
    }*/

    public static int climbStairs1(int n) {
        // 创建一个数组来保存历史数据，
        // 数组下标是从0开始的，返回结果想用dp[n]，所以就需要n+1,如果这里是n的话，结果就需要是dp[n-1]表示第n个台阶，一样的
        int[] dp = new int[n + 1];
        // 给出初始值, 爬楼梯的初始值应该是爬 1 级有1 种，2级的话有 2 种, 题目n是正整数，不考虑
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs1(2));
    }

}
