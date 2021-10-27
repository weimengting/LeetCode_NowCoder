package start_130;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//注意，此处不能使用静态static，因为创建多少个实例操作的都是同一个变量
public class Partition_131 {
    public static void main(String[] args) {
        String s = "aab";
        Partition_131 pp = new Partition_131();
        List<List<String>> listList = pp.partition(s);
        System.out.println(listList);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> curSet = new Stack<>();
        backTrace(s, res, curSet);
        System.out.println(res);
        return res;
    }

    public void backTrace(String s, List<List<String>> res, Stack<String> curSet){
        if(s.isEmpty()){
            res.add(new ArrayList<>(curSet));
            return;
        }
        for (int i = 1; i <= s.length(); i ++){
            String curStr = s.substring(0, i);
            String leftStr = s.substring(i);
            if (!isPalindromic(curStr)){
                continue;   //不能break，该处不合适只能说明当前的子字符串不符合，并不能说明该循环的下一组不符合
            }
            curSet.push(curStr);
            backTrace(leftStr, res, curSet);
            curSet.pop();
        }
    }

    public boolean isPalindromic(String s){
        StringBuilder bf = new StringBuilder(s);
        String rr = bf.reverse().toString();
        return rr.equals(s);
    }
}
