//没调出来，同样的测试用例在本地ide没问题，到了网站就报错，贴一个别人的答案
//想法是利用排列组合将所有可能的情况列举出来，再用substring进行判断



package start_30;

import java.util.*;
import java.util.stream.Collectors;

class Solution_st {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list=new ArrayList<>();
        //边界
        if(words==null||words.length==0||s==null||s.length()==0) return list;
        //哈希表一保存words的字符串和次数
        Map<String,Integer> map=new HashMap<>();
        int len=words[0].length();
        int num=words.length;
        int total=len*num;

        for(int i=0;i<num;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        //截断
        for(int i=0;i<s.length()-total+1;i++){
            //哈希表二保存截断s的字符串和次数
            Map<String,Integer> map1=new HashMap<>();
            for(int j=i;j<i+total;j+=len){
                String c=s.substring(j,j+len);
                map1.put(c,map1.getOrDefault(c,0)+1);
            }
            //比较是否相等
            if(map.equals(map1)) list.add(i);
        }
        return list;
    }
}




public class concatenate_all_substrings_30 {
    public static void main(String[] args) {
        Solution sr = new Solution();
        String[] tt = {"word","good","best","word"};
        List<Integer> ll = sr.findSubstring("wordgoodgoodgoodbestword", tt);
        System.out.println(ll);
    }
}



class Solution {
    public static Stack<String> stack = new Stack<>();

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> inds = new ArrayList<>();
        //int shu[] = {1, 2, 3, 4};
        inds = f(words, words.length ,0, inds, s);
        return inds;
    }

    private static List<Integer> f(String[] words, int targ, int cur, List<Integer> inds, String s) {
        if (cur == targ) {
            List<String> temp = new ArrayList<>();
            temp.addAll(stack);
            int[] res = isValid(temp, words, s);
            if (res[0] == 1){
                //System.out.println(stack);
                inds.add(res[1]);
            }
            return inds;
        }

        for(int i = 0;i < words.length; i ++) {
            stack.add(words[i]);
            f(words, targ, cur + 1, inds, s);
            stack.pop();
        }
        return inds;
    }

    private static int[] isValid(List<String> list, String[] words, String s){
        List<String> list_ori = new ArrayList<>();
        int[] res = new int[2];
        for (String word : words) {
            list_ori.add(word);
        }
        String sb = list.stream().collect(Collectors.joining());
        Collections.sort(list);
        Collections.sort(list_ori);
        if (list.equals(list_ori)) {
            if (s.contains(sb)){
                res[0] = 1;
                res[1] = s.indexOf(sb);
            }
        }
        return res;
    }
}
