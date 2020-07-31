package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum_1 {

    public int[] twoSum_low(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //for (int j = 1; j < nums.length; j++) {   第一次写成了 j=1,这样第二层遍历每次都从1开始
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            // 这里的i 不能是自己 i != map.get(nums[i]) 不对，应该是
            if (map.containsKey(tmp) && i != map.get(tmp)) {
                // return new int[]{i,tmp}; 返回的是下标，是value
                return new int[]{i, map.get(tmp)};
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum_1 obj = new TwoSum_1();
        for (int i : obj.twoSum(nums, 18)) {
            System.out.println(i);
        }
    }


}
