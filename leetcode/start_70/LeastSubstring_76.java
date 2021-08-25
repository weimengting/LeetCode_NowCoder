package start_70;

//自己的做法会超时，但算法思路是一致的，双指针
//能通过就不错了，不要搞什么算法优化了

import java.util.HashMap;
import java.util.Map;

public class LeastSubstring_76 {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        char[] sp = s.toCharArray();
        new LeastSubstring_76().minWindow(s, t);
    }
//    public String minWindow(String s, String t) {
//        int m = t.length();
//        int min = Integer.MAX_VALUE;
//        String res = "";
//        Map<Character, Integer> t_map = new HashMap<>();
//        Map<Character, Integer> temp = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            if (!t_map.keySet().contains(c)){
//                t_map.put(c, 1);
//            }
//            else {
//                int tr = t_map.get(c);
//                tr += 1;
//                t_map.put(c, tr);
//            }
//        }
//        int start = 0;
//        int end = start + m;
//        int loop = 1;
//
//        while (end - start >= m){
//            if (loop == 1 && end <= s.length()){
//                if(!check(s.substring(start, end), t_map)){
//                    end ++;
//                }
//                else {
//                    int len = end - start;
//                    if (len < min){
//                        min = len;
//                        res = s.substring(start, end);
//                    }
//                    loop = 2;
//                    start ++;
//                }
//            }
//            else if (loop == 2){
//                if(check(s.substring(start, end), t_map)){
//                    int len = end - start;
//                    if (len < min){
//                        min = len;
//                        res = s.substring(start, end);
//                    }
//                    start ++;
//                }
//                else {
//                    loop = 1;
//                    end ++;
//                }
//            }
//            else {
//                break;
//            }
//        }
//        System.out.println(res);
//        return res;
//    }
//
//    private boolean check(String subS, Map<Character, Integer> t_map){
//        Map<Character, Integer> temp = new HashMap<>();
//        for (char c : subS.toCharArray()) {
//            if (!temp.containsKey(c)){
//                temp.put(c, 1);
//            }
//            else {
//                int tr = temp.get(c);
//                tr += 1;
//                temp.put(c, tr);
//            }
//        }
//        for (Character character : t_map.keySet()) {
//            if (temp.containsKey(character)){
//                if (temp.get(character) < t_map.get(character)){
//                    return false;
//                }
//            }
//            else {
//                return false;
//            }
//        }
//        return true;
//    }

    public String minWindow(String s, String t) {
        String res = "";
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> chars = new HashMap<>();
        int len1 = s.length(), len2 = t.length();
        for(int i = 0; i < len2; i++) {
            char ch = t.charAt(i);
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);  //如果有值则加一，否则放入并对应默认值加一
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while(right < len1) {
            char ch1 = s.charAt(right);
            window.put(ch1, window.getOrDefault(ch1, 0) + 1);
            while(check(window, chars)) { //说明此时end对应的字符串满足条件
                if((right - left + 1) < min) {
                    min = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                char ch2 = s.charAt(left);
                window.put(ch2, window.get(ch2) - 1);
                if(window.get(ch2) == 0)
                    window.remove(ch2);  //remove函数可以直接删除某个键值对
                left++;
            }
            right++;
        }
        return res;
    }

    //当前窗口是否符合题目条件
    public boolean check(Map<Character, Integer> window, Map<Character, Integer> chars) {
        for(char ch : chars.keySet()) {
            if(!window.containsKey(ch) || (window.get(ch) < chars.get(ch)))
                return false;
        }
        return true;
    }
}