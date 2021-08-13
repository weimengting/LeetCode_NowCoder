package start_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterGroup_49 {
    public static void main(String[] args) {
        String[] strs = {""};
        new LetterGroup_49().groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sp = Arrays.toString(c);
            if (!hm.containsKey(sp)){
                List<String> ll = new ArrayList<>();
                ll.add(str);
                hm.put(sp, ll);
            }
            else {
                List<String> ll = hm.get(sp);
                ll.add(str);
                hm.put(sp, ll);
            }
        }
        List<List<String>> res = new ArrayList<>(hm.values());
        System.out.println(res);
        return res;
    }
}
