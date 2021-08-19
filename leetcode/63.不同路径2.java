package start_60;

//动态规划，需要考虑障碍物存在的情况

public class DifferentRoute2_63 {
    public static void main(String[] args) {
        int[][] nums = {{0, 0}};
        int res = new DifferentRoute2_63().uniquePathsWithObstacles(nums);
        //System.out.println(res);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i ++){
            if (obstacleGrid[i][0] == 1){
                break;
            }
            res[i][0] = 1;
        }
        for (int j = 0; j < n; j ++){
            if (obstacleGrid[0][j] == 1){
                break;
            }
            res[0][j] = 1;
        }
        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                if (obstacleGrid[i][j] != 1){
                    res[i][j] = res[i][j - 1] + res[i - 1][j];
                }

            }
        }

        System.out.println(res[m - 1][n - 1]);
        return res[m - 1][n - 1];
    }




}
