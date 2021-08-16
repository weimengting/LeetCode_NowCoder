package start_50;

//边界元素的判定很磨人

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        new SpiralMatrix_54().spiralOrder(matrix);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;int j = 0;
        int direction = 1;
        for (int count = 0; count < m *n; count ++){
            res.add(matrix[i][j]);
            matrix[i][j] = 200;
            if (direction == 1 && (j == n - 1 || matrix[i][j + 1] == 200)){
                direction = 2;
            }

            if (direction == 2 && (i == m - 1 || matrix[i + 1][j] == 200)){
                direction = 3;
            }

            if (direction == 3 && (j == 0 || matrix[i][j - 1] == 200)){
                direction = 4;
            }

            if (direction == 4 && (i == 0 || matrix[i - 1][j] == 200)){
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
        System.out.println(res);
        return res;
    }
}
