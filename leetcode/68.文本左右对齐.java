package start_60;

//没什么技巧性，找好规律

import java.util.ArrayList;
import java.util.List;

public class TextJustify_68 {
    public static void main(String[] args) {
        String[] words = {"Sciencewwwwwwwwww"};
        int maxWidth = 16;
        new TextJustify_68().fullJustify(words, 20);
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> cur_words = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            cur_words.add(word);
        }
        List<Object> ll = new ArrayList<>();
        while (cur_words.size() > 0){
            ll = singleLine(cur_words, maxWidth);
            if (ll.size() == 0){
                break;
            }
            res.add((String) ll.get(0));
            for (int i = 0; i < (Integer) ll.get(1); i ++){
                cur_words.remove(0);
            }
        }
        if (cur_words.size() > 0){
            res.add(lastLine(cur_words, maxWidth));
        }
        //System.out.println(res);
        //singleLine(cur_words, maxWidth);
        return res;
    }

    public List<Object> singleLine(List<String> cur_words, int maxWidth){
        List<String> temp = new ArrayList<>();
        List<Object> rr = new ArrayList<>();
        int cur_len = cur_words.get(0).length();
        temp.add(cur_words.get(0));

        for (int i = 1; i < cur_words.size(); i ++){
            cur_len += (cur_words.get(i).length() + 1);
            if (cur_len <= maxWidth){
                temp.add(cur_words.get(i));
            }
            else {
                break;
            }
        }
        if (temp.size() == cur_words.size()){
            return rr;
        }
        int total = 0;
        for (String s : temp) {
            total += s.length();
        }
        int left = maxWidth - total;
        int positions = temp.size() - 1;
        if (positions == 0){
            String yu = lastLine(temp, maxWidth);
            rr.add(yu);
            rr.add(temp.size());
            return rr;
        }

        int initial_num = left / positions;
        int reduant = left % positions;
        List<String> backspaces = new ArrayList<>();

        for (int i = 1; i <= positions; i ++){
            StringBuilder tt = new StringBuilder();
            for (int j = 1; j <= initial_num; j ++){
                tt.append(" ");
            }
            backspaces.add(tt.toString());
        }
        String[] spaces = new String[positions];
        for (int i = 0; i < positions; i ++){
            spaces[i] = backspaces.get(i);
        }
        for (int i = 1; i <= reduant; i ++){
            String tt = backspaces.get(i - 1);
            tt += " ";
            spaces[i - 1] = tt;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < temp.size(); i ++){
            res.append(temp.get(i));
            if (i < spaces.length){
                res.append(spaces[i]);
            }
        }

        rr.add(res.toString());
        rr.add(temp.size());
        //System.out.println(res);
        return rr;
    }

    public String lastLine(List<String> cur_words, int maxWidth){
        int num = cur_words.size();
        String res = cur_words.get(0);
        for (int i = 1; i < num; i ++){
            res += " ";
            res += cur_words.get(i);
        }
        int cur_len = res.length();
        for (int i = 0; i < maxWidth - cur_len; i ++){
            res += " ";
        }
        return res;
    }
}
