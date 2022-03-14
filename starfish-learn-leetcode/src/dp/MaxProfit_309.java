package dp;

/**
 * @author Henry
 * @date 2022/3/11
 */
public class MaxProfit_309 {

    public static int getMaxProfit(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];

        //特例，第1天最大利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //特例，第2天最大利润
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for(int i = 2;i<n;i++){
            //卖出状态
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //买入状态，昨天卖出后，需要隔一天才能再次买进
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 4, 2, 7};
        System.out.println(getMaxProfit(prices));
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //特例
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 卖出状态
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 买入状态
            if (i < 2) {
                // 前三天不用考虑冷冻期的问题，因为不可能出现冷冻期
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            } else {
                // 从第4天开始，买入考虑一天的冷冻期
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[len - 1][0];
    }

}
