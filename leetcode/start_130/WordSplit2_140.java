package start_130;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordSplit2_140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        new WordSplit2_140().wordBreak(s, wordDict);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> paths = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(s, wordDict, 0, paths, res);
        return res;
    }

    /**
     *
     * @param s
     * @param wordDict
     * @param index ：当前位于整个字符串的哪个索引上
     * @param paths :存放满足条件的分割的子字符串
     */
    private void dfs(String s, List<String> wordDict, int index, List<String> paths, List<String> res){
        if (index == s.length()){
            String sp = paths.stream().collect(Collectors.joining(" "));
            res.add(sp);
            return;
        }

        for (int i = index; i < s.length(); i ++){
            if (wordDict.contains(s.substring(index, i + 1))){
                paths.add(s.substring(index, i + 1));
                dfs(s, wordDict, i + 1, paths, res);
                paths.remove(paths.size() - 1);
            }
        }
    }
}
