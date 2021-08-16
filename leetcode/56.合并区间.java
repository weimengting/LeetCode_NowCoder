package start_50;

//最难的地方在处理边界上，冒泡法排序

public class MergeInterval_56 {
    public static void main(String[] args) {
        int[][] inters = {{1, 1}};
        new MergeInterval_56().merge(inters);
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }
        int m = intervals.length;
        int n = intervals[0].length;
        int[][] res = new int[m][n];
        int count = 0;
        int sign = 0;
        for (int i = 0; i < m - 1; i ++){
            for (int j = 0; j < m - 1 - i; j ++){
                if (intervals[j][0] > intervals[j + 1][0]){
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < m - 1; i ++){
            if (intervals[i][1] >= intervals[i + 1][0]){
                res[count][0] = intervals[i][0];
                res[count][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
                sign = i + 1;  //记录是否区间合并到了最后一个元素
            }
            else {
                res[count][0] = intervals[i][0];
                res[count][1] = intervals[i][1];
                count += 1;
            }
        }
        if (sign != m - 1){  //判断是否区间合并到了最后一个元素，如果没有，添加最后一行，否则不添加
            res[count][0] = intervals[m - 1][0];
            res[count][1] = intervals[m - 1][1];
        }
        count = 1;
        for (int i = 1; i < m; i ++){
            if (res[i][0] == 0 && res[i][1] == 0 && (res[i - 1][0] != 0 || res[i - 1][1] != 0)){
                break;
            }
            count += 1;
        }
        System.out.println(count);
        int[][] pri = new int[count][n];
        for (int i = 0; i < count; i ++) {
            for (int j = 0; j < n; j ++){
                pri[i][j] = res[i][j];
            }
        }
        return pri;
    }

}
