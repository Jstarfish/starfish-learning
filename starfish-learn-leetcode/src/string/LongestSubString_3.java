package string;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 */
public class LongestSubString_3 {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcee"));
    }


    public static int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        //为了有左右指针的思想，我把我们常用的 i 写成了 right
        for (int right = 0; right < s.length(); right++) {
            //当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
            //那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
            //相当于左指针往前移动了一位
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            //右指针一直往前移动
            map.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}
