package math;

/**
 * 回文数：回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author Henry
 * @date 2022/6/12
 */
public class PalindromeNum_9 {

    public boolean isPalindrome(int num){
        String revertNum = new StringBuilder(""+num).reverse().toString();
        return revertNum.equals(num+"");
    }

    /**
     * 考虑整数溢出问题，所以反转一半，其实如果是回文数，反转后也一样，所以不存在溢出
     * @param num
     * @return
     */
    public boolean isPalindromeNum(int num){
        if(num < 0 || (num % 10 == 0 && num > 0)){
            return false;
        }

        int tmp = 0;

        while(num > tmp){
            tmp = num % 10 + tmp * 10;
            num = num / 10;
        }

        return tmp == num || num / 10 == tmp;

    }

}
