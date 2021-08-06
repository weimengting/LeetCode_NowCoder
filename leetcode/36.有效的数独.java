package start_30;

//所有'.'符号都应该认为合法
//判断是否重复时应该排除做比较的元素


public class Sudoku_36 {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution_36 solution_36 = new Solution_36();
        boolean res = solution_36.isValidSudoku(board);
        System.out.println(res);
    }
}

class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        int row = board[1].length;
        int col = board[0].length;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (!isValid(board[i][j], i, j, board)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char c, int i_ind, int j_ind, char[][] board){
        //判断该行是否有重复元素
        if (c == '.'){
            return true;
        }
        for (int i = 0; i < board[0].length; i ++){
            if (c == board[i_ind][i] && i != j_ind){
                return false;
            }
        }
        //判断该列是否有重复元素
        for (int i = 0; i < board[1].length; i ++){
            if (c == board[i][j_ind] && i != i_ind){
                return false;
            }
        }
        //判断9宫格内是否有重复元素
        int start_i = (i_ind / 3) * 3;
        int start_j = (j_ind / 3) * 3;
        for (int i = start_i; i < start_i + 3; i ++){
            for (int j = start_j; j < start_j + 3; j ++){
                if (c == board[i][j] && !(i == i_ind && j == j_ind)){
                    return false;
                }
            }
        }
        return true;
    }
}
