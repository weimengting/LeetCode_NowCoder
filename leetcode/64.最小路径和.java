package start_60;

//动态规划

public class LeastSumOfRoutes_64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        new LeastSumOfRoutes_64().minPathSum(grid);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 1; i < m; i ++){
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j ++){
            res[0][j] = res[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(res[m - 1][n - 1]);
        return res[m - 1][n - 1];
    }
}
