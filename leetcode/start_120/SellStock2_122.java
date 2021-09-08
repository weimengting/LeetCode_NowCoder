package start_120;

/**
 * 动态规划：
 *          设dp[i][0]表示第i天交易完成后手里没有股票的最大利润，由此可以延伸出两种情况：
 *          1.股票在前一天已经卖出，今天也没有买入，此时dp[i][0] = dp[i - 1][0]
 *          2.股票在前天结束时存有一张，今天把它卖出了，此时dp[i][0] = dp[i - 1][1] + prices[i - 1]
 *          设dp[i][1]表示第i天交易完成后手里持有一张股票的最大利润，由此可以延伸出两种情况：
 *          1.这张股票是今天才拿到的，此时dp[i][1] = dp[i - 1][0] - prices[i - 1]（买股票要花钱的）
 *          2.这张股票昨天就有，今天还在，说明没卖出，此时dp[i][1] = dp[i - 1][1]
 *          （注意当天数i = 1的时候可能存在负债的情况）
 */

public class SellStock2_122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i ++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i - 1], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length][0], dp[prices.length][1]);
    }
}
