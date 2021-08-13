package start_30;

/**动态规划：
 * 总问题： s是否与p匹配
 * 子问题：s的前i个字符组成的串是否与p的前j个字符组成的串是否匹配
 * dp数组，ismatch[i][j]存放布尔值数据，i，j为自变量
 * 当自变量取i，j时，因变量的值与什么因素有关
 * 1.如果对于当前i，j，如果p[j]是字母，起不了替代作用，则只有s[i]与p[j]相等，且之前的字符串也匹配的情况下才能匹配
 * 2.如果对于当前i，j，如果p[j]是问号？，可以匹配任意字符，则在之前的字符串也匹配的情况下才能匹配
 * 3.如果对于当前i，j，如果p[j]是星号*，可以匹配0以及字符串，有两种情况，第一：上次匹配星号已经匹配过：isMatch[i - 1][j]且为真
 *                                                                  第二：上次匹配星号尚未匹配过：isMatch[i][j - 1]且为真
 */


public class ZhengzeMatch_44{
    public static void main(String[] args) {
        String s = "";
        String p = "****";
        ZhengzeMatch_44 zhengzeMatch_44 = new ZhengzeMatch_44();
        zhengzeMatch_44.isMatch(s, p);
    }

    public boolean isMatch(String s, String p) {
        return dp(s, p);
    }

    public boolean dp(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean[][] isMatch = new boolean[m + 1][n + 1];
        isMatch[0][0] = true;

        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                isMatch[0][i] = true;
            } else {
                break;
            }
        }


        for (int i = 1; i < m + 1; i ++){
            for (int j = 1; j < n + 1; j ++){
                if (p.charAt(j - 1) >= 'a' && p.charAt(j - 1) <= 'z'){
                    isMatch[i][j] = (s.charAt(i - 1) == p.charAt(j - 1)) && isMatch[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '?'){
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*'){
                    isMatch[i][j] = isMatch[i - 1][j] || isMatch[i][j - 1];
                }
            }
        }
        System.out.println(isMatch[m][n]);
        return isMatch[m][n];
    }
}