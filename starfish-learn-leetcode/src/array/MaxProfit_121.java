package array;

/**
 * 看 dp 包下
 *
 */
public class MaxProfit_121 {


    public int getMaxProfit(int[] nums) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minPrice) {
                minPrice = nums[i];
            } else if (nums[i] - minPrice > maxProfit) {
                maxProfit = nums[i] - minPrice;

            }
        }
        return maxProfit;

    }

}
