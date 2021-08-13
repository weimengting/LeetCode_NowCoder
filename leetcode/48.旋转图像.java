package start_30;

//先上下翻转，在对角线元素互换

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //先上下翻转矩阵
        int start = 0;
        int end = m - 1;
        while (start < end){
            for (int i = 0; i < n; i ++){
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            start ++;
            end --;
        }
        //对角线元素互换
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (i > j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
