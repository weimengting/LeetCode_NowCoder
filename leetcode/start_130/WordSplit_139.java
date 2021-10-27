package start_130;

//该题的正解是采用动态规划，参考背包问题

import java.util.ArrayList;
import java.util.List;

public class WordSplit_139 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        boolean rr = new WordSplit_139().wordBreak2(s, wordDict);
        System.out.println(rr);
    }
    //原思路是枚举字典中所有的单词，查看其是否在字符串中，是则将其删除，但这样会造成不连续的单词也会拼接在一起，与题目的本意相违背
    //另一种回溯法的思路是枚举所有的字符串，查看其是否在字典中，是则删除(不采用，太烧脑了)
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Boolean> res = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        dfs(s, wordDict, res, used, 0);
        return res.size() > 0;
    }

    private void dfs(String s, List<String> wordDict, List<Boolean> res, boolean[] used, int curInd){
        if (curInd == s.length()){
            res.add(true);
            return;
        }

        for (int i = curInd + 1; i <= s.length(); i ++){
            if (used[curInd] || res.size() > 1){
                break;
            }
            String tmp = s.substring(curInd, i);
            if (!wordDict.contains(tmp)){
                continue;
            }
            used[curInd] = true;
            dfs(s.substring(i), wordDict, res, used, i);
            used[curInd] = false;
        }
    }

    //动态规划吧，为什么要跟自己过不去呢
    //if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true
    public boolean wordBreak2(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i ++){
            for (int j = 0; j < i; j ++){
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
