package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Henry
 * @date 2021/12/28
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class MinWindow_76 {

    public static String minWindow(String s, String t) {
        // 用来记录窗口中的字符和数量
        Map<Character,Integer> window = new HashMap();
        // 需要凑齐的字符和数量
        Map<Character,Integer> need = new HashMap();
        // 构建need字符集
        for (int i = 0; i < t.length(); i++) {
            char needChar = t.charAt(i);
            need.put(needChar,need.getOrDefault(needChar,0)+1);
        }

        int left = 0,right = 0,valid = 0;
        // valid是用来记录窗口中满足need要求的字符和数量的数目，比如need中要求字符a数量为2，如果window中的a字符的数量等于了2，valid就＋1，反之-1
        int len = Integer.MAX_VALUE;  // 记录最小字串的长度
        int start = 0;  // 记录最小字串的起始位置
        while(right < s.length()){
            char addChar = s.charAt(right);  // 即将要加入window的字符
            window.put(addChar,window.getOrDefault(addChar,0) + 1);
            right++;
            // 如果加入的字符是need中要求的字符，并且数量已经达到了need要求的数量，则valid+1
            // 这里和下面都有个坑，window.get(addChar)和need.get(addChar)返回的都是对象，最好用.equals()方法比较大小
            if(need.containsKey(addChar) && window.get(addChar).equals(need.get(addChar))){
                valid++;
            }
            // 当window中记录的字符和数量满足了need中要求的字符和数量，考虑缩窗口
            while(valid == need.size()){
                // 先判断当前的最小覆盖字串是否比之前的最小覆盖字串短
                if(right - left < len){  // 注意，这里上面已经对right实施了++操作，所以这里的长度不是right - left + 1
                    len = right - left ;
                    start = left;  // 如果最短，则记录下该最小覆盖字串的起始位置
                }
                char removeChar = s.charAt(left);
                // 开始缩减窗口，left右移，如果要从window删除的字符正好是need中需要的并且，数目也等于need中需要的数目，则删减后，该该字符要求的数量
                // 显然不满足need要求的数量，所以valid要-1；
                if(need.containsKey(removeChar) && window.get(removeChar).equals(need.get(removeChar))){
                    valid--;
                }
                window.put(removeChar,window.get(removeChar) - 1);
                left++;
            }

        }
        // 如果最小覆盖字串的长度相对于定义时没变，则t不包含s中所有的字符，返回"",如果长度改变过，说明存在这样的最小覆盖字串，直接输出。
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }


}
