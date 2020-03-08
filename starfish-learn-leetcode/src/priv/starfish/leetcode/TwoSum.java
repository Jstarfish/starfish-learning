package priv.starfish.leetcode;

import java.util.HashMap;
import java.util.Map;


public class TwoSum {

    public static int[] twoSum(int[] nums,int target){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};

            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }



        public int[] twoSum1(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[] { i, j };
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }



    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};

        int target = 9;
        System.out.println(twoSum(nums,target));

    }
}
