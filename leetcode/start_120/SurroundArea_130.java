package start_120;

/**
 * 击败5%。。。。枯了
 * 最近的这10道题为何如此优秀？
 * 解题方法还是老套的回溯算法，重点在如何发现这是一个需要回溯来解的题目
 * 数组和其他容器一样，在递归过程中不会重新安排地址，只会改变指针
 *记录走过的路径时，用数组存放true，false进行判断时速度会更快
 * 题目思路：
 *          反向思考：如何确定这个‘O’是否应该被替换为‘X’
 *          1.所有的边界位置
 *          2.所有与边界的‘O’相邻的为‘O’的位置
 *          3.所有与已认定为‘O’相邻的为‘O’的位置
 *          上面三种情况都不会被替换
 */
//{{'X','O','X'},{'O','X','O'},{'X','O','X'}    {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}}

public class SurroundArea_130 {
    public static void main(String[] args) {
        char[][] board = {{'X','O','X'},{'O','X','O'},{'X','O','X'}};
        new SurroundArea_130().solve(board);

    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        //Set<List<Integer>> res = new HashSet<>();
        boolean[][] backup = new boolean[m][n];
        for (int i = 0; i < n; i ++){
            boolean[][] route = new boolean[m][n];
            dfs(board, m - 1, i, route, backup);
        }
        for (int i = 0; i < n; i ++){
            boolean[][] route = new boolean[m][n];
            dfs(board, 0, i, route, backup);
        }
        for (int i = 0; i < m; i ++){
            boolean[][] route = new boolean[m][n];
            dfs(board, i, 0, route, backup);
        }
        for (int i = 0; i < m; i ++){
            boolean[][] route = new boolean[m][n];
            dfs(board, i, n - 1, route, backup);
        }
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (backup[i][j]){
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
        //System.out.println(res);
    }
    private void dfs(char[][] board, int i, int j, boolean[][] used, boolean[][] backup){
        if (board[i][j] == 'X'){
            return;
        }
        used[i][j] = true;
        if (board[i][j] == 'O'){
            backup[i][j] = true;
        }

        //上方
        if (i - 1 >= 0){
            if (!used[i - 1][j]){
                dfs(board, i - 1, j, used, backup);
            }
        }

        //下方
        if (i + 1 < board.length){
            if (!used[i + 1][j]) {
                dfs(board, i + 1, j, used, backup);
            }
        }

        //左方
        if (j - 1 >= 0){
            if (!used[i][j - 1]) {
                dfs(board, i, j - 1, used, backup);
            }
        }
        //右方
        if (j + 1 < board[0].length){
            if (!used[i][j + 1]) {
                dfs(board, i, j + 1, used, backup);
            }
        }
    }
}

/**
 * int m = board.length;
 *         int n = board[0].length;
 *
 *         Set<List<Integer>> res = new HashSet<>();
 *
 *         for (int i = 0; i < n; i ++){
 *             boolean[][] route = new boolean[m][n];
 *             dfs(board, m - 1, i, res, route);
 *         }
 *         for (int i = 0; i < n; i ++){
 *             boolean[][] route = new boolean[m][n];
 *             dfs(board, 0, i, res, route);
 *         }
 *         for (int i = 0; i < m; i ++){
 *             boolean[][] route = new boolean[m][n];
 *             dfs(board, i, 0, res, route);
 *         }
 *         for (int i = 0; i < m; i ++){
 *             boolean[][] route = new boolean[m][n];
 *             dfs(board, i, n - 1, res, route);
 *         }
 *         for (int i = 0; i < m; i ++){
 *             for (int j = 0; j < n; j ++){
 *                 List<Integer> temp = new ArrayList<>();
 *                 temp.add(i);
 *                 temp.add(j);
 *                 if (res.contains(temp)){
 *                     board[i][j] = 'O';
 *                 }
 *                 else {
 *                     board[i][j] = 'X';
 *                 }
 *             }
 *         }
 *         //System.out.println(res);
 *     }
 *     private void dfs(char[][] board, int i, int j, Set<List<Integer>> res, boolean[][] used){
 *         if (board[i][j] == 'X'){
 *             return;
 *         }
 *         used[i][j] = true;
 *         if (board[i][j] == 'O'){
 *             List<Integer> temp = new ArrayList<>();
 *             temp.add(i);
 *             temp.add(j);
 *             res.add(temp);
 *         }
 *
 *         //上方
 *         if (i - 1 >= 0){
 *             if (!used[i - 1][j]){
 *                 dfs(board, i - 1, j, res, used);
 *             }
 *         }
 *
 *         //下方
 *         if (i + 1 < board.length){
 *             if (!used[i + 1][j]) {
 *                 dfs(board, i + 1, j, res, used);
 *             }
 *         }
 *
 *         //左方
 *         if (j - 1 >= 0){
 *             if (!used[i][j - 1]) {
 *                 dfs(board, i, j - 1, res, used);
 *             }
 *         }
 *         //右方
 *         if (j + 1 < board[0].length){
 *             if (!used[i][j + 1]) {
 *                 dfs(board, i, j + 1, res, used);
 *             }
 *         }
 *     }
 */
