package start_110;

/**
 * 这道题本质上还是字符串匹配（可以先画一个二维的表初步观察一下有什么规律）
 * 动态规划：设dp[i][j]表示s的前i个字符串中与t的前j个满足条件的个数
 *          走到某个字符时，有这样两种情况：
 *          1.两个位置上对应的字符相等，这时：
 *                              使用s的该字符，即与t的抵消（转化成原题可以理解为是保留），则dp[i][j] += dp[i - 1][j - 1]
 *                              不使用s的该字符，即转化成原题可以理解为删除，则dp[i][j] += dp[i - 1][j]
 *                              这种情况下的dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
 *          2.两个位置上对应的字符不相等，即s里面该位置的字符只能删除，此时dp[i][j] = dp[i - 1][j]
 *          3.另外考虑一种情况，当s的长度小于t的长度时，即i < j，一定不存在使条件成立的情况
 */

import java.util.ArrayList;
import java.util.List;

public class DifferentSubstring_115 {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int res = new DifferentSubstring_115().numDistinct2(s, t);
        System.out.println(res);
    }
    public int numDistinct(String s, String t) {
        List<Integer> num = new ArrayList<>();
        if (s.length() == t.length()){
            return s.equals(t) ? 1 : 0;
        }
        dfs(s, t, num);
        System.out.println(num);
        return num.size();
    }

    //暴力搜索(就知道会超时。。。。。。。)
    private void dfs(String cur_str, String t, List<Integer> num){
        if (t.length() == 0){
            num.add(1);
            return;
        }

        for (int i = 0; i < cur_str.length(); i ++){
            if (cur_str.charAt(i) != t.charAt(0)){
                continue;
            }
            dfs(cur_str.substring(i + 1), t.substring(1), num);
        }
    }

    public int numDistinct2(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i ++){
            dp[i][0] = dp[0][0];
        }
        for (int i = 1; i <= m; i ++){
            for (int j = 1; j <= n; j ++){
                if (i < j){
                    continue;
                }

                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
