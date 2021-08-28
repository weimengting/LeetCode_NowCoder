package start_80;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//套用上一题的方法：示意图见 D:\java_projects\temp\src\start_80\85_ref.png


//{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}
public class LargestRectangle_85 {
    public static void main(String[] args) {
        char[][] matrix = {{}};
        int res = new LargestRectangle_85().maximalRectangle(matrix);
        System.out.println(res);
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i ++){
            int[] nums = new int[n];
            for (int j = 0; j < n; j ++){
                if (matrix[i][j] == '1'){
                    int temp = cal(matrix, i, j);
                    nums[j] = temp;
                }
                else {
                    int temp = 0;
                    nums[j] = temp;
                }
            }
            int area = new Histogram_84().largestRectangle2(nums);
            res.add(area);
        }
        Collections.sort(res);
        return res.size() > 0 ? res.get(res.size() - 1) : 0;
    }

    private int cal(char[][] matrix, int i, int j){
        int count = 0;
        for (int m = i; m >= 0; m --){
            if (matrix[m][j] == '0'){
                break;
            }
            count ++;
        }
        return count;
    }
}
