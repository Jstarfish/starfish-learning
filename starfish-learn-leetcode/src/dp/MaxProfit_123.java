package dp;

/**
 * @author Henry
 * @date 2022/3/11
 */
public class MaxProfit_123 {

    public static void main(String[] args) {
        //int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int[] prices = new int[]{3,3,5,0};
        System.out.println(getMaxProfit(prices));


    }

    public static int getMaxProfit(int[] prices){
        int max_k = 2;
        int n = prices.length;
        int dp[][][] = new int[n][3][2];

        //特例
//        dp[0][1][0] = 0;
//        dp[0][1][1] = - prices[0];
//        dp[0][2][0] = 0;
//        dp[0][2][1] = - prices[0];

        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k <= max_k; k++) {
                //特例，
                if (i == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
