package start_70;

//二分法，right - left > 1防止出现死循环

public class ExploreMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 16;
        boolean res = new ExploreMatrix_74().searchMatrix(matrix, target);
        System.out.println(res);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] temp = new int[m];
        for (int i = 0; i < m; i ++){
            temp[i] = matrix[i][0];
        }
        int left = 0;
        int right = m - 1;
        if (temp[left] == target || temp[right] == target){
            return true;
        }
        while (right - left > 1){
            int middle = left + (right - left) / 2;
            if (temp[middle] > target){
                right = middle;
            }
            else if (temp[middle] < target){
                left = middle;
            }
            else {
                return true;
            }
        }
        for (int i = left; i <= right; i ++){
            for (int j = 0; j < n; j ++){
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        System.out.println(left);
        System.out.println(right);
        return false;
    }
}
