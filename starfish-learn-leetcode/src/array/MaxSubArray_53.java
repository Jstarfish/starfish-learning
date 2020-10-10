package array;

/**
 * @description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 */
public class MaxSubArray_53 {


    //暴力法
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;

            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp > max) max = temp;
            }
        }
        return max;
    }

    // 动态规划
    public int maxSubArray2(int[] nums) {
        //特判
        if(nums==null || nums.length==0) {
            return 0;
        }
        for(int i = 1; i < nums.length; i++){
            //若前一个元素大于0，则将它加到当前元素上
            if(nums[i-1] > 0){
                //现在每个nums[i]里面保存的是以原先nums[i]结尾的最大子序和
                nums[i] = nums[i-1] + nums[i];
            }
        }
        //再遍历一边nums[i],找出最大的那个数就是整个数组的最大子序和
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //初始化
        int length = nums.length;
        int[] dp = new int[length];
        // 初始值,只有一个元素的时候最大和即它本身
        dp[0] = nums[0];
        int ans = nums[0];
        // 状态转移
        for (int i = 1; i < length; i++) {
            // 取当前元素的值 和 当前元素的值加上一次结果的值 中最大数
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            // 和最大数对比 取大
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{-2};
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        //特判
//        if(nums==null || nums.length==0) {
//            return 0;
//        }
        //初始化
        int length = nums.length;
        int[] dp = new int[length];
        // 初始化最大值
        int ans = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < length; i++){
            // 取当前元素的值 和 当前元素的值加上一次结果的值 中最大数
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            // 和最大数对比 取大
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
