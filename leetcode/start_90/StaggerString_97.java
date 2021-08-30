package start_90;

//双指针的方法并不能解决问题，有的指针会走错位置

/**
 * 动态规划：定义dp[i][j]表示s1的前i个元素和s2的前j个元素能否交错成s3的前i + j个元素，相应的，有两种情况：
 *          1.s1的第i个元素和s3的第i + j个元素是否相等，则dp[i][j]是否为真取决于s1的前i - 1个元素和s2的前j个元素能否交错成s3的前i + j - 1个元素，即dp[i - 1][j]是否为真
 *          2.s2的第j个元素和s3的第i + j个元素是否相等，则dp[i][j]是否为真取决于s2的前j - 1个元素和s1的前i个元素能否交错成s3的前i + j - 1个元素，即dp[i][j - 1]是否为真
 *          否则为false
 */

public class StaggerString_97 {
    public static void main(String[] args) {
//        String sp = "123456";
//        System.out.println(sp.substring(0, 1));
        boolean res = new StaggerString_97().isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(res);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0){
            return true;
        }
        if (s1.length() == 0){
            return s2.equals(s3);
        }
        if (s2.length() == 0){
            return s1.equals(s3);
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i ++){
            for (int j = 0; j <= n; j ++){
                if (i > 0){
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                        dp[i][j] = dp[i - 1][j];
                        if (dp[i][j]){ //此时如果为true的话就不需要向下执行了，否则后面会更改dp[i][j]的值，也就是说，两个条件满足其一即可
                            continue;
                        }
                    }
                }
                if (j > 0){
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
