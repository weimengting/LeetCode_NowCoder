package DP;

/**首先从思路上简化问题，对于原题目提出的要求，其实每一行有且只能有一个皇后
 * 可以类比为排列组合的问题，先来放第一行，由于是第一个棋子，所以这一行的所有位置都有可能
 * 在存放棋子位置的时候，将下一行不能存放的位置记录并保存，之后进行dfs的递归
 * 如果顺利到达终点，存放数据，并返回上一个节点，注意，此时返回节点，在原来行中是相当于执行完了dfs，会继续向下走
 * 因此接下来的操作就是将该节点存放的used数据全部弹出，然后到该行的下一个节点，对应该树层的下一个分支上
 * 在相同的左对角线的元素满足行下标与列下标之和相等，相同的右对角线元素满足行下标与列下标之差相等
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Nqueen_51<generateRes> {
    public static void main(String[] args) {
        new Nqueen_51<>().solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queen = new int[n];
        Stack<Integer> col = new Stack<>();
        Stack<Integer> diag_left = new Stack<>();
        Stack<Integer> disg_right = new Stack<>();
        dfs(queen, col, diag_left, disg_right, 0, n, res);
        System.out.println(res);
        return res;
    }

    private void dfs(int[] queen, Stack<Integer> col, Stack<Integer> diag_left,
                     Stack<Integer> diag_right, int row, int n, List<List<String>> res){
        if (row == n){
            res.add(generateRes(queen));
            return;
        }
        for (int i = 0; i < n; i ++){
            if (col.contains(i)){
                continue;
            }
            int left_temp = row + i;
            if (diag_left.contains(left_temp)){
                continue;
            }
            int right_temp = row - i;
            if (diag_right.contains(right_temp)){
                continue;
            }
            queen[row] = i;
            col.add(i);
            diag_left.add(left_temp);
            diag_right.add(right_temp);
            dfs(queen, col, diag_left, diag_right, row + 1, n, res);
            col.pop();
            diag_left.pop();
            diag_right.pop();
            queen[row] = -1;
        }
    }
    private List<String> generateRes(int[] queen){
        List<String> result = new ArrayList<>();
        int n = queen.length;
        for (int i = 0; i < n; i ++){
            StringBuilder ss = new StringBuilder();
            for (int j = 0; j < n; j ++){
                if (j == queen[i]){
                    ss.append("Q");
                }
                else {
                    ss.append(".");
                }
            }
            result.add(ss.toString());
        }
        return result;
    }
}
