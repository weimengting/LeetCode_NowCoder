package start_50;

//使用上题使用的方法，省去排序的步骤
//冒泡法对于大长度的数组是非常耗时的

public class InsertRange_57 {
    public static void main(String[] args) {
        int[][] intevals = {{1,3},{1,9}};
        int[] newInterval = {0,5};
        int[][] res = new InsertRange_57().insert(intevals, newInterval);
        for (int i = 0; i < res.length; i ++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int[][] inte_after = new int[m + 1][2];
        int ind = m;
        for (int i = 0; i < m; i ++){
            if (intervals[i][0] >= newInterval[0]){
                ind = i;
                break;
            }
        }
        for (int i = 0; i < ind; i ++){
            inte_after[i] = intervals[i];
        }
        inte_after[ind] = newInterval;
        if (ind < m){
            for (int i = ind + 1; i < m + 1; i ++){
                inte_after[i] = intervals[i - 1];
            }
        }
        inte_after = merge(inte_after);
        return inte_after;
    }

    private int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }
        int m = intervals.length;
        int n = intervals[0].length;
        int[][] res = new int[m][n];
        int count = 0;
        int sign = 0;

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
        //System.out.println(count);
        int[][] pri = new int[count][n];
        for (int i = 0; i < count; i ++) {
            for (int j = 0; j < n; j ++){
                pri[i][j] = res[i][j];
            }
        }
        return pri;
    }
}
