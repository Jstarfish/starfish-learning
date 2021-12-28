package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * > ```
 * > 输入：nums = [4,3,2,7,8,2,3,1]
 * > 输出：[5,6]
 * > ```
 * > 输入：nums = [1,1]
 * > 输出：[2]
 * > ```
 */
public class DisappearedNumber_448 {

    public static List<Integer> findNumbers(int[] nums){
        List<Integer> list = new ArrayList<>();
        int[] x = new int[nums.length + 1];
        //用一个新的数组，占位，数据长度大1，原数组元素放在对应的下边下，最后数组位是0的就是缺失元素
        for (int i = 0; i < nums.length; i++) {
            x[nums[i]]++;
        }
        for (int i = 1; i < x.length; i++) {
            if(x[i] == 0){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findNumbers(nums));
    }

}
