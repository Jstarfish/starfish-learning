package dp;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange_322 {

    public static int coinChange(int[] coins, int amount) {
        //定义数组
        int[] dp = new int[amount + 1];

        int max = amount + 1;
        // 初始化每个值为 amount+1，这样当最终求得的 dp[amount] 为 amount+1 时，说明问题无解
        Arrays.fill(dp, max);

        //初始值
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        //dp[i]上的值不断选择已含有硬币值当前位置的数组值 + 1，min保证每一次保存的是最小值
        for (int i = 1; i < amount + 1; i++) {
            //内层 for 循环在求所有选择的最小值 状态转移方程
            for (int coin : coins) {
                if (i >= coin) {
                    //分两种情况，使用硬币coin和不使用，取最小值
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        // 初始化每个值为 amount+1，这样当最终求得的 dp[amount] 为 amount+1 时，说明问题无解
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amout = 11;
        System.out.println(coinChange1(coins,amout));

    }

}
