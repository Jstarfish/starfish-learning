package array.twopointer;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class MaxAverage_643 {

    public static double getMaxAverage(int[] nums, int k) {
        int sum = 0;
        //先算出前k个数字和，然后逐步往右移
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int result = sum;
        for (int i = k; i < nums.length; i++) {
            //从第k个数字开始，算出最大的
            result = Math.max(result, sum + nums[i] - nums[i - k]);
        }
        return 1.0 * result / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(getMaxAverage(nums,4));

    }
}
