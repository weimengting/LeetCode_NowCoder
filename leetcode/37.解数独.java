package start_30;

//深度优先搜索，回溯法，字符串和单个字符的转换


public class Solve_sudoku_37 {
    public static void main(String[] args) {
        String[][] boar = {{"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};
        char[][] bb = new char[9][9];


        for (int i = 0; i < boar[1].length; i ++){
            for (int j = 0; j < boar[0].length; j ++){
                bb[i][j] = boar[i][j].charAt(0);
//                System.out.print(bb[i][j] + " ");
            }
//            System.out.println();
        }

        for (int i = 0; i < bb[1].length; i ++){
            for (int j = 0; j < bb[0].length; j ++){
                boar[i][j] = String.valueOf(bb[i][j]);
                System.out.print(boar[i][j] + " ");
            }
            System.out.println();
        }


        Solution_37 solution_37 = new Solution_37();
//        solution_37.solveSudoku(boar);
//        for (char t = '1'; t <= '9'; t ++){
//            System.out.println(t);
//        }
//
//    }


}

static class Solution_37 {
    public void solveSudoku(char[][] board) {

        String[][] boar = new String[board[1].length][board[0].length];
        for (int i = 0; i < board[1].length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                boar[i][j] = String.valueOf(board[i][j]);
            }
        }
        dfs(boar, 0, 0);
        for (int i = 0; i < board[1].length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                board[i][j] = boar[i][j].charAt(0);
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean dfs(String[][] board, int i, int j){
        if (i == 9){
            return true;
        }

        if (board[i][j].equals(".")){
            for (int k = 1; k <= 9; k ++){
                board[i][j] = String.valueOf(k);
                if (isValid(String.valueOf(k), i, j, board) && dfs(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1)){
                    return true;
                }
            }
            board[i][j] = ".";
            return false;
        }
        else{
            return dfs(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        }
    }

    private boolean isValid(String c, int i_ind, int j_ind, String[][] board){
        //判断该行是否有重复元素
        if (c .equals(".")){
            return true;
        }
        for (int i = 0; i < board[0].length; i ++){
            if (c.equals(board[i_ind][i]) && i != j_ind){
                return false;
            }
        }
        //判断该列是否有重复元素
        for (int i = 0; i < board[1].length; i ++){
            if (c.equals(board[i][j_ind]) && i != i_ind){
                return false;
            }
        }
        //判断9宫格内是否有重复元素
        int start_i = (i_ind / 3) * 3;
        int start_j = (j_ind / 3) * 3;
        for (int i = start_i; i < start_i + 3; i ++){
            for (int j = start_j; j < start_j + 3; j ++){
                if (c.equals(board[i][j]) && !(i == i_ind && j == j_ind)){
                    return false;
                }
            }
        }
        return true;
    }
}