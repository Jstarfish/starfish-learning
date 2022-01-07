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
        //先求出前k个数的和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        //然后从第 K 个数开始移动，保存移动中的和值，返回最大的
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        //返回的是double
        return 1.0 * maxSum / k;
    }
//
//    public static double getMax1(int[] nums,int k){
//        int sum = 0;
//        int left = 0;
//        int right = k;
//        int maxSum = 0;
//        while(right < nums.length){
//            for (int i = k; i < nums.length; i++) {
//                sum += nums[i];
//                maxSum = Math.max(sum,maxSum);
//                right++;
//                k++;
//            }
//        }
//        return 1.0 * maxSum / k;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(getMaxAverage(nums,4));

    }
}
