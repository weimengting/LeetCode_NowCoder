package start_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SellStock_121 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        new SellStock_121().maxProfit2(prices);
    }

    //超时（估计暴搜也会超时）
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i ++){
            for (int j = i + 1; j < prices.length; j ++){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return Math.max(max, 0);
    }

    //动态规划
    public int maxProfit2(int[] prices){
        int[] dp = new int[prices.length + 1];
        if (prices.length == 1){
            return 0;
        }
        dp[2] = (prices[1] > prices[0]) ? (prices[1] - prices[0]) : 0;
        int min = Math.min(prices[0], prices[1]);
        for (int i = 3; i < dp.length; i ++){
            if (prices[i - 1] - min > dp[i - 1]){
                dp[i] = prices[i - 1] - min;
            }
            else {
                dp[i] = dp[i - 1];
            }
            min = Math.min(min, prices[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[prices.length];
    }
}
