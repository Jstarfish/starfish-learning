package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Henry
 * @date 2021/11/25
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum_15 {

    public static void main(String[] args) {
        //int[] nums = {-1,0,1,1,1,2,-1,-4};
        //int[] nums = {-1,0,1,2,-1,-4};
        //int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3) return null;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) break;
            int left = i + 1;
            int right = nums.length - 1;

            if(nums[i]==nums[i-1]) continue;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left]==nums[left+1]) left ++;
                    while(left < right && nums[right]==nums[right-1]) right --;
                    left ++;
                    right --;
                }else if(sum > 0) right--;
                else if(sum < 0) left ++;
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumX(int[] nums) {
        //存放结果list
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        //特例判断
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            //排序后的第一个数字就大于0，就说明没有符合要求的结果
            if (nums[i] > 0) break;

            //去重, 不能是 nums[i] == nums[i +1 ]，会造成遗漏
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //左右指针
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //去重（相同数字的话就移动指针）
                    //在将左指针和右指针移动的时候，先对左右指针的值，进行判断,以防[0,0,0]这样的造成数组越界
                    //不要用成 if 判断，只跳过 1 条，还会有重复的
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    //移动指针
                    l++;
                    r--;
                }
                else if (sum < 0) l++;
                else if (sum > 0) r--;
            }
        }
        return result;
    }


}
