package dp;

/**
 * @author Henry
 * @date 2022/3/11
 */
public class MaxProfit_188 {

    public static void main(String[] args) {

    }

    public static int getMaxProfit(int max_k, int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        //因为一次交易至少涉及两天，所以如果k大于总天数的一半，就直接取天数一半即可，多余的交易次数是无意义的
        max_k = Math.min(max_k, n / 2);

        int[][][] dp = new int[n][max_k + 1][2];
        //特例:第1天，不持有随便交易 0，持有的话就是 -prices[0]
        for (int k = 0; k <= max_k; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }


}
