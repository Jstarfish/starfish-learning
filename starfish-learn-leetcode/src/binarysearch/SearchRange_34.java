package binarysearch;

import java.util.Random;

/**
 * @author Henry
 * @date 2022/3/15
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 */
public class SearchRange_34 {


    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);
        return new int[]{first, last};
    }

    public int binarySearch(int[] nums, int target, boolean findLast) {
        int length = nums.length;
        int left = 0, right = length - 1;
        //结果，因为可能有多个值，所以需要先保存起来
        int index = -1;
        while (left <= right) {
            //取中间值
            int middle = left + (right - left) / 2;

            //找到相同的值（只有这个地方和普通二分查找有不同）
            if (nums[middle] == target) {
                //先赋值一下，肯定是找到了，只是不知道这个值是不是在区域的边界内
                index = middle;
                //如果是查找最后的
                if (findLast) {
                    //那我们将浮标移动到下一个值试探一下后面的值还是否有target
                    left = middle + 1;
                } else {
                    //否则，就是查找第一个值，也是同理，移动指针到上一个值去试探一下上一个值是不是等于target
                    right = middle - 1;
                }

                //下面2个就是普通的二分查找流程，大于小于都移动指针
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            System.out.println(new Random().nextInt(9) + 2);
        }

    }

    public int[] query(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        //1,2,2,5,6,7,9
        while(left < right){
            int mid = left + (right - left)/2;
            if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(nums[right] != target){
            return new int[]{-1,-1};
        }
        int L = right;
        left = 0;
        right = nums.length - 1;
        while(left < right){

        }


        return new int[]{-1,-1};
    }

}
