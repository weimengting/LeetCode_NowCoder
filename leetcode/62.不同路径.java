package start_60;

/**
 * 动态规划
 * 原问题：走到终点的路径数
 * 子问题：走到某一位置i，j的路径数
 * 某一个位置只有两种到达可能
 */

public class DifferentRoute_62 {
    public static void main(String[] args) {
        new DifferentRoute_62().uniquePaths(3, 3);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j ++){
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
        return dp[m - 1][n - 1];
    }
}
