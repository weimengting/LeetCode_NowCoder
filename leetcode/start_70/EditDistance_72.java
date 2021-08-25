package start_70;

//动态规划

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class EditDistance_72 {
    public static void main(String[] args) {
        int res = new EditDistance_72().minDistance("horse", "ros");
        System.out.println(res);
    }
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0){
            return word2.length();
        }
        if (word2.length() == 0){
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i ++){
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j ++){
            dp[0][j] = j;
        }
        for (int i = 1; i < word1.length() + 1; i ++){
            for (int j = 1; j < word2.length() + 1; j ++){
                List<Integer> temp = new ArrayList<>();
                temp.add(dp[i - 1][j] + 1);
                temp.add(dp[i][j - 1] + 1);
                int tt = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                temp.add(tt);
                Collections.sort(temp);
                dp[i][j] = temp.get(0);
            }
        }
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];
    }

}
