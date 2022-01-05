package array.twopointer;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个已按照 非递减顺序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum_167 {

    public static int[] towSum(int[] nums, int target) {
        int left = 0;
        int rigth = nums.length - 1;
        //for (int i = 0; i < nums.length; i++) {
        while(left < rigth){
            int tmp = nums[left] + nums[rigth];
            if (target == tmp) {
                return new int[]{left, rigth};
            }
            if (tmp > target) {
                //右移
                rigth--;
            }
            if (tmp < target) {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(towSum(numbers, 9)));
    }


}
