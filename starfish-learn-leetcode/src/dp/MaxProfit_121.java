package dp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 *  示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit_121 {

    /**
     * 暴力法
     * @param prices
     * @return
     */
    public int maxprofit(int[] prices){
        int length = prices.length;
        int dp[] = new int[length];

        //int maxProfit = Integer.MIN_VALUE;
        int minPrices = dp[0];
        for(int i = 0;i<length;i++){
            minPrices = Math.min(minPrices,prices[i]);
            dp[i] = Math.max(dp[i-1],prices[i]-minPrices);
        }
        return dp[length-1];
    }

    /**
     * 单次循环
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i< prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    public int getMaxProfit(int[] nums){
        int length = nums.length;
        if(length < 0) return 0;
        int dp[] = new int[length];
        int minProfit = nums[0];
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<nums.length;i++){
            min =  Math.min(nums[i],min);
            dp[i] = Math.max(dp[i-1],nums[i]-min);
        }
        return dp[length-1];
    }

    /**
     * dp 法
     * @param prices
     * @return
     */
    public static int dp(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int dp[] = new int[length];
        int minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[length - 1];
    }

    /**
     * 通用公式法
     * @param prices
     */
    public static int dp_ik(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        //特例
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];
    }



    public static void main(String[] args) {
        int[] nums = new int[]{7};
        System.out.println(maxProfit(nums));
        System.out.println(dp_ik(nums));


        List<User> list = null;
        User user1 = new User();
        user1.setUserName("a");
        user1.setUserId(null);
        list.add(user1);
        //User user = new User();
//        list.add(user);
        list.stream().sorted(Comparator.comparing(user -> user.getUserId())).collect(Collectors.toList());

        final Function<String,String> stringFunction = value -> (null==value ? "":value);

        //user.setUserName(stringFunction.apply(user.getUserName()));
        //user.setUserId(1);

        //System.out.println(user.toString());
    }


     static class User{
        String userName;
        Integer userId;

         public Integer getUserId() {
             return userId;
         }

         public void setUserId(Integer userId) {
             this.userId = userId;
         }

         public void setUserName(String userName) {
             this.userName = userName;
         }

         public String getUserName() {
             return userName;
         }

         public User(String userName, Integer userId) {
             this.userName = userName;
             this.userId = userId;
         }

         public User(){}

         @Override
         public String toString() {
             return "User{" +
                     "userName='" + userName + '\'' +
                     ", userId=" + userId +
                     '}';
         }
     }

    public int getResult(int[] arrays){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0;i<arrays.length;i++){
            if(arrays[i] < minPrice){
                minPrice = arrays[i];
            }else if(arrays[i] - minPrice > maxProfit){
                maxProfit = arrays[i] - minPrice;
            }
        }
        return maxProfit;

    }

}
