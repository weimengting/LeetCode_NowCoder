package start_70;

//回溯算法

import java.util.ArrayList;
import java.util.List;

public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCESEECS";
        boolean res = new WordSearch_79().exist(board, word);
        System.out.println(res);
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        List<List<Integer>> list = new ArrayList<>();
        //以单词的第一个字母为起点，对不同的起点进行回溯，在回溯过程中，已经走过的路径用used进行标记
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (board[i][j] == word.charAt(0)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int k = 0; k < list.size(); k ++){
            List<Integer> tt = list.get(k);
            boolean[][] used = new boolean[m][n];
            used[tt.get(0)][tt.get(1)] = true;
            dfs(0, word, board, tt.get(0), tt.get(1), res, used);
            if (res.size() > 0){
                return true;
            }
        }
        return false;
    }

    private void dfs(int cur_len, String word, char[][] board, int i, int j, List<Boolean> res, boolean[][] used){
        if (cur_len == word.length() - 1 && word.charAt(cur_len) == board[i][j]){
            res.add(true);
            return;
        }
        if (res.size() > 0){
            return;
        }
        //检查左边的格子
        if (j - 1 >= 0){
            if (board[i][j - 1] == word.charAt(cur_len + 1) && !used[i][j - 1]){
                used[i][j - 1] = true;
                dfs(cur_len + 1, word, board, i, j - 1, res, used);
                used[i][j - 1] = false;
            }
        }
        //检查右边的格子
        if (j + 1 < board[0].length){
            if (board[i][j + 1] == word.charAt(cur_len + 1) && !used[i][j + 1]){
                used[i][j + 1] = true;
                dfs(cur_len + 1, word, board, i, j + 1, res, used);
                used[i][j + 1] = false;
            }
        }
        //检查上面的格子
        if (i - 1 >= 0){
            if (board[i - 1][j] == word.charAt(cur_len + 1) && !used[i - 1][j]){
                used[i - 1][j] = true;
                dfs(cur_len + 1, word, board, i - 1, j, res, used);
                used[i - 1][j] = false;
            }
        }
        //检查下面的格子
        if (i + 1 < board.length){
            if (board[i + 1][j] == word.charAt(cur_len + 1) && !used[i + 1][j]){
                used[i + 1][j] = true;
                dfs(cur_len + 1, word, board, i + 1, j, res, used);
                used[i + 1][j] = false;
            }
        }
    }
}
