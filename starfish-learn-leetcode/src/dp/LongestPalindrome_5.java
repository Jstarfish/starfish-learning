package dp;

/**
 * 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 */
public class LongestPalindrome_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("xabcbae"));
    }


    public static String longestPalindrome(String s) {
        char[] chas = s.toCharArray();
        int strLen = chas.length;
        boolean[][] dp = new boolean[strLen][strLen];
        int length = 0;
        //用来保存两个指针
        int[] res = new int[2];

        for(int r=0;r<chas.length;r++){
            for(int l=r;l>=0;l--){
                if(chas[l] ==chas[r] && (r-l<2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                }
                if(r-l+1 > length){
                    res[0] = l;
                    res[1] = r;
                    length = r-l+1;
                }
            }
        }
        return s.substring(res[0],res[1]+1);
    }

    public String longestPalindrome_1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean dp[][] = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        //通过最大长度定位回文串位置，或者也可以用个数组记录int[] res = new int[2];
        int maxLen = 1;
        int begin = 0;
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (chars[l] != chars[r]) {
                    dp[l][r] = false;
                } else {
                    // 特例，如果 是 abaa 这种，需要最后一个和第一个也相等，但是他们距离大于等于了3，所以还需要往里判断
                    if (r - l < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }

                //只要 dp[l][r] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    }
