package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Nqueen_52 {
    public static void main(String[] args) {
        new Nqueen_52().totalNQueens(4);
    }
    public int totalNQueens(int n) {
        List<Integer> rest = new ArrayList<>();
        Stack<Integer> col = new Stack<>();
        Stack<Integer> diag_left = new Stack<>();
        Stack<Integer> disg_right = new Stack<>();
        dfs(col, diag_left, disg_right, 0, n, rest, 0);
        System.out.println(rest);
        return rest.size();
    }

    private void dfs(Stack<Integer> col, Stack<Integer> diag_left,
                     Stack<Integer> diag_right, int row, int n, List<Integer> rest, int temp){
        if (row == n){
            rest.add(temp);
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
            col.add(i);
            diag_left.add(left_temp);
            diag_right.add(right_temp);
            dfs(col, diag_left, diag_right, row + 1, n, rest, temp);
            col.pop();
            diag_left.pop();
            diag_right.pop();
        }
    }

}
