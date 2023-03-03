package dp;

/**
 * @author Henry
 * @date 2022/3/8
 * 给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
 *
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 */
public class MaxProfit_122 {


    public static int maxProfit1(int[] prices){
//        int n = prices.length;
//        int dp0 = 0, dp1 = -prices[0];
//        for (int i = 1; i < n; ++i) {
//            int newDp0 = Math.max(dp0, dp1 + prices[i]);
//            int newDp1 = Math.max(dp1, dp0 - prices[i]);
//            dp0 = newDp0;
//            dp1 = newDp1;
//        }
//        return dp0;
        // [7,1,5,3,6,4]

        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 0; i < n; i++) {
            //int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }

    public int maxProfit(int[] prices){
        int n = prices.length;
        int [][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
    }

    public static int getMaxProfit(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

}
