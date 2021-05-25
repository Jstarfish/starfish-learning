package ink.starfish;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: starfish
 * @date: 2021/5/20 17:35
 */
public class TwoSum {


    public static void main(String[] args) {
        int[] nums = new int[]{2,5,7,11};
        int target = 9;

        TwoSum sum = new TwoSum();

        for (int i : sum.twoNum_2(nums, target)) {
            System.out.println(i);
        }

    }

    public int[] twoNum_1(int[] nums,int target){
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1; i<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    public int[] twoNum_2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}