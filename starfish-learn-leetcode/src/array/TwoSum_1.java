package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 */
public class TwoSum_1 {

    // hash法  O(n) 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }



        // 暴力法 O(n^2)
        public static int[] twoSum1(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[] { i, j };
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

//        public static int[] twoSum2Point(int[] arr,int target){
//            Arrays.sort(arr);
//            int left = 0;
//            int right = arr.length - 1;
//            for(int i = 0;i<arr.length;i++) {
//                if (arr[left] + arr[right] == target) {
//                    return new int[] {left, right};
//                } else if (arr[left] + arr[right] < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//            return new int[] {};
//        }



    public static void main(String[] args) {
        System.err.println("Usage: [target]");
        System.out.println("aaaaa");
        int[] nums = new int[]{2,7,11,15};

        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

}
