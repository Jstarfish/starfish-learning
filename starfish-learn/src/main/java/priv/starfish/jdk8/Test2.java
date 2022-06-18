package priv.starfish.jdk8;

/**
 * @author Henry
 * @date 2022/6/17
 */
public class Test2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,9,11};
        System.out.println(search(nums,9));
    }

    public static int search(int[] nums,int target){
        int l = 0;
        int r = nums.length -1;
        while(l <= r){
            //int mid = l + (r - l)/2;
            int mid = (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid -1;
            }
        }
        return -1;
    }
}
