package array;

/**
 * @author Henry
 * @date 2021/11/26
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class MaxArea_11 {

    public static int maxArea1(int[] height){
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        while(l < r){
            int area = Math.min(height[l],height[r]) * (r - l);
            result = Math.max(area,result);
            if(height[l] > height[r]) r--;
            else l ++;
        }
        return result;
    }



    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while(left < right){
            //水量 = 两个指针指向的数字中较小值∗指针之间的距离
            int area = Math.min(height[left],height[right]) * (right - left);
            result = Math.max(result,area);
            //往哪个方向移动需要考虑好，
            if(height[left] <= height[right]){
                right --;
            }else{
                left++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //int[] nums = new int[]{1,1};
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(nums));
    }
}
