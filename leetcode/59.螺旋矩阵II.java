package start_50;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix2_59 {
    public static void main(String[] args) {
        new SpiralMatrix2_59().generateMatrix(4);
    }
    public int[][] generateMatrix(int k) {
        int[][] res = new int[k][k];
        int m = res.length;
        int n = res[0].length;
        int i = 0;int j = 0;
        int direction = 1;
        for (int count = 0; count < m *n; count ++){
            res[i][j] = count + 1;
            if (direction == 1 && (j == n - 1 || res[i][j + 1] > 0)){
                direction = 2;
            }

            if (direction == 2 && (i == m - 1 || res[i + 1][j] > 0)){
                direction = 3;
            }

            if (direction == 3 && (j == 0 || res[i][j - 1] > 0)){
                direction = 4;
            }

            if (direction == 4 && (i == 0 || res[i - 1][j] > 0)){
                direction = 1;
            }

            if (direction == 1){
                j ++;
            }
            if (direction == 2){
                i ++;
            }
            if (direction == 3){
                j --;
            }
            if (direction == 4){
                i --;
            }
        }

        return res;
    }
}
