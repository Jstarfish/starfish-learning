package ink.starfish;

/**
 * @description: 买卖股票的最佳时机
 * @author: starfish
 * @date: 2021/5/20 19:47
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};

        int max = 0;
        for(int i=0;i<prices.length;i++){
            for (int j = i+1; j <prices.length ; j++) {
                int tmp = prices[j] - prices[i];
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        System.out.println(max);
    }
}
