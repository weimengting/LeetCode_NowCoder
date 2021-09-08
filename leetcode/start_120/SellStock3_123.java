package start_120;

//灵魂拷问：为什么要浪费时间在这么折磨人的题目上。。。。

import java.util.Arrays;

/**
 * 对于任意一天，可能存在的状态有几种，应该写成几维的矩阵
 * 定义状态转移数组dp[天数][当前是否持股][卖出的次数]
 *
 * 具体一天结束时的6种状态：
 *
 * 1.未持股，未卖出过股票：说明从未进行过买卖，利润为0
 *      dp[i][0][0]=0
 * 2.未持股，卖出过1次股票：可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
 *      dp[i][0][1]=max(dp[i-1][1][0]+prices[i],dp[i-1][0][1])
 * 3.未持股，卖出过2次股票:可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
 *      dp[i][0][2]=max(dp[i-1][1][1]+prices[i],dp[i-1][0][2])
 * 4.持股，未卖出过股票：可能是今天买的，也可能是之前买的（昨天也持股）
 *      dp[i][1][0]=max(dp[i-1][0][0]-prices[i],dp[i-1][1][0])
 * 5.持股，卖出过1次股票：可能是今天买的，也可能是之前买的（昨天也持股）
 *      dp[i][1][1]=max(dp[i-1][0][1]-prices[i],dp[i-1][1][1])
 * 6.持股，卖出过2次股票：最多交易2次，这种情况不存在
 *      dp[i][1][2]=float('-inf')
 *
 */

public class SellStock3_123 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        new SellStock3_123().maxProfit(prices);
    }
    public int maxProfit(int[] prices) {
        float[][][] dp = new float[prices.length + 1][2][3];
        //第一天结束后的情况
        dp[1][0][0] = 0;
        dp[1][0][1] = Float.NEGATIVE_INFINITY;
        dp[1][0][2] = Float.NEGATIVE_INFINITY;
        dp[1][1][0] = -prices[0];
        dp[1][1][1] = Float.NEGATIVE_INFINITY;
        dp[1][1][2] = Float.NEGATIVE_INFINITY;
        for (int i = 2; i <= prices.length; i ++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i - 1], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i - 1], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i - 1], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i - 1], dp[i - 1][1][1]);
            dp[i][1][2] = Float.NEGATIVE_INFINITY;
        }
        float max = 0;
        for (int i = 0; i < 2; i ++){
            for (int j = 0; j < 3; j ++){
                max = Math.max(dp[prices.length][i][j], max);
            }
        }
        return (int) max;
    }
}
