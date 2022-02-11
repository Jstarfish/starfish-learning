package dp;

import java.util.Arrays;

/**
 * @author Henry
 * @date 2022/1/24
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class LengthOfLIS_300 {

    public static int getLengthOfLIS(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return length;
        }

        int dp[] = new int[length];

        Arrays.fill(dp,1);
        for(int i = 0;i<length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i = 0;i<length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(getLengthOfLIS(nums));

    }

}
