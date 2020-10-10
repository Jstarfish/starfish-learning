package dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {

        //定义二维数组保存路径
        int dp[][] = new int[m][n];

        //定义初始值
        for (int i = 0; i < m; i++) {
            dp[m][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][n] = 1;
        }

        // 排除初始值的情况，都从 1 开始循环
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[m][n] = dp[m - 1][n] + dp[m][n - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
