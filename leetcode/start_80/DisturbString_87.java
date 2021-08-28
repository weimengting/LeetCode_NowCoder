package start_80;

import java.util.*;

/**
 * 抄作业：
 *      动态规划：
 *      原问题：字符串S能否通过该算法变换到T
 *      子问题：字符串S中起始为i的长度为len的子字符串能否变换到字符串T中起始为j的长度为len的子字符串
 *      不太符合动态规划的递推关系，递归会比较容易理解，但代码比较难实现
 *
 *      给定两个字符串 T 和 S，假设 T 是由 S 变换而来
     * 如果 T和 S长度不一样，必定不能变来
     * 如果长度一样，顶层字符串 S 能够划分为 S_1和 S_2，同样字符串 T 也能够划分为 T_1和 T_2
     * 情况一：没交换，S_1 ==> T_1，S_2 ==> T_2
 *     情况二：交换了，S_1 ==> T_2 ，S_2 ==> T_1
 *          子问题就是分别讨论这两种情况
 */

public class DisturbString_87 {
    //用动态规划解决
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s1.length() != s2.length()){
            return false;
        }
        else if(s1.length() == 1 && !s1.equals(s2)){
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        for (int len = 2; len <= n; len ++){
            for (int i = 0; i <= n - len; i ++){
                for (int j = 0; j <= n - len; j ++){
                    for (int k = 1; k < len; k ++){
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]){
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]){
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }


    //用递归解决
    Set<String> visited = new HashSet<>();  //增加剪枝操作，否则会超时（添加全局变量）
    public boolean isScramble2(String s1, String s2){
        //和上面一样，先特别判断，提高效率
        if (s1.length() != s2.length()){
            return false;
        }
        if(s1.length() == 1 && !s1.equals(s2)){
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }
        if (visited.contains(s1 + "-" + s2)){
            return false;
        }
        visited.add(s1 + "-" + s2);
        //字符串含有的内容不一样的，直接返回false
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i ++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (Character character : map.keySet()) {
            if (map.get(character) != 0){
                return false;
            }
        }
        int n = s1.length();
        for (int i = 1; i < n; i ++){  //不同的i表示不同的分割位置
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))){
                return true;
            }
        }
        return false;
    }
}
