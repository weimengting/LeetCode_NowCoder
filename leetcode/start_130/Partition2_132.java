package start_130;

import java.util.*;

//歪个楼，看到评论里一大堆说生为CV，我很抱歉的，没反应过来，想了半天才知道是ctrl + c，ctrl + v


public class Partition2_132 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(s.substring(1,3));
        Partition2_132 pp = new Partition2_132();
        int listList = pp.minCut(s);
    }

    //超时
//    public int minCut(String s) {
//        List<Integer> res = new ArrayList<>();
//        Stack<String> curSet = new Stack<>();
//        backTrace(s, res, curSet);
//        System.out.println(res);
//        Collections.sort(res);
//        return res.get(0);
//    }
//
//    public void backTrace(String s, List<Integer> res, Stack<String> curSet){
//        if(s.isEmpty()){
//            List<String> tmp = new ArrayList<>(curSet);
//            res.add(tmp.size() - 1);
//            return;
//        }
//        for (int i = 1; i <= s.length(); i ++){
//            String curStr = s.substring(0, i);
//            String leftStr = s.substring(i);
//            if (!isPalindromic(curStr)){
//                continue;   //不能break，该处不合适只能说明当前的子字符串不符合，并不能说明该循环的下一组不符合
//            }
//            curSet.push(curStr);
//            backTrace(leftStr, res, curSet);
//            curSet.pop();
//        }
//    }
//
//    public boolean isPalindromic(String s){
//        StringBuilder bf = new StringBuilder(s);
//        String rr = bf.reverse().toString();
//        return rr.equals(s);
//    }

    //动态规划，这一题的难点在于对于前i个字符串就是回文串的需要单独考虑，换言之，它不需要上一个状态转移过来
    public int minCut(String s){
        int len = s.length();
        int[] res = new int[len + 1];
        res[1] = 0;
        for (int i = 2; i <= len; i ++){
            List<Integer> tt = new ArrayList<>();
            if (isPalindromic(s.substring(0, i))){
                res[i] = 0;
                continue;
            }
            for (int j = 1; j < i; j ++){
                //substring：从索引j开始到索引i的前一个
                String tmp = s.substring(j, i);
                if (isPalindromic(tmp)){
                    tt.add(res[j] + 1);
                }
            }
            Collections.sort(tt);
            res[i] = tt.get(0);
        }
        System.out.println(res[len]);
        return res[len];
    }


    public boolean isPalindromic(String s){
        StringBuilder bf = new StringBuilder(s);
        String rr = bf.reverse().toString();
        return rr.equals(s);
    }
}
