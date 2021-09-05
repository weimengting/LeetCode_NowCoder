package start_110;

import java.util.*;

public class MinRouteSum_120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> tt = new ArrayList<>();
        tt.add(2);
        triangle.add(tt);
        tt = new ArrayList<>();
        tt.add(3);tt.add(4);
        triangle.add(tt);
        tt = new ArrayList<>();
        tt.add(6);tt.add(5);tt.add(7);
        triangle.add(tt);
        tt = new ArrayList<>();
        tt.add(4);tt.add(1);tt.add(8);tt.add(3);
        triangle.add(tt);
        System.out.println(triangle);
//        triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        new MinRouteSum_120().minimumTotal2(triangle);
    }

    //暴力搜索，再次超时。。。。。。可惜了我连Java8的新特性都用上了
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        List<Integer> sum = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(triangle, sum, 0, stack, 0);
        Collections.sort(sum);
        System.out.println(sum);
        return sum.get(0);
    }

    private void dfs(List<List<Integer>> triangle, List<Integer> sum, int point, Stack<Integer> stack, int start){
        if (point == triangle.size()){
            sum.add(stack.stream().mapToInt(x -> x).sum());
            return;
        }
        for (int i = start; i <= Math.min(start + 1, triangle.get(point).size() - 1); i ++){
            List<Integer> temp = new ArrayList<>(triangle.get(point));
            stack.push(temp.get(i));
            dfs(triangle, sum, point + 1, stack, i);
            stack.pop();
        }
    }

    //自己想动态规划的解法时，一直有一个疑问，从上面一行到下面的一行存在递推关系吗，答案是不存在，因为上一行中最小路径所选用的节点
    //不能保证下一行找最小路径时也用到
    //所以答案建立了从起点到三角形的任意一点的路径之间的转移方程,关系如下
    //dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + cur_row[j](注意考虑边界条件)
    public int minimumTotal2(List<List<Integer>> triangle){
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i ++){
            for (int j = 0; j <= i; j ++){
                if (j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                else if (j < i){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                else if (j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
            }
        }
        System.out.println(Arrays.toString(dp[3]));
        Arrays.sort(dp[m - 1]);
        System.out.println(dp[m - 1][0]);
        return dp[m - 1][0];
    }
}
