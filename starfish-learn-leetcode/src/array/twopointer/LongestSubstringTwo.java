package array.twopointer;

/**
 * 给定一个字符串 s，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 */
public class LongestSubstringTwo {

    public int getResult(String s){
        int length = s.length();
        if(length < 3){
            return length;
        }
        int result = 2;
        char[] chars = s.toCharArray();
        int[] freq = new int[128];
        //滑动窗口里不同字符的个数
        int count = 0;
        //定义左右指针
        int left = 0;
        int right = 0;
        while(right < length){
            freq[chars[right]]++;
            if (freq[chars[right]] == 1) {
                count++;
            }
            right++;

            while (count == 3) {
                freq[chars[left]]--;
                if (freq[chars[left]] == 0) {
                    count--;
                }
                left++;
            }
            // 退出循环以后有 count = 2，因此在这里选出最大值
            result = Math.max(result, right - left);
        }
        return result;




    }


}
