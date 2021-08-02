import javax.print.DocFlavor;
import java.util.*;

public class phone_number {
    public static void main(String[] args) {
        Solution_de po = new Solution_de();
        po.letterCombinations("2345");
    }
}


class Solution_de{
    public List<String> letterCombinations(String digits) {
        List<String> vocabulary = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        List<String> ss = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        if (digits.length() == 0) {return ss;}
        for (char c : digits.toCharArray()) {
            digit.add(vocabulary.get(c - '0' - 2));
        }
        System.out.println(digit);
        for (char s : digit.get(0).toCharArray()) {
            ss.add(String.valueOf(s));
        }
        System.out.println(ss);
        if (digit.size() == 1) {return ss;}
        else {
            for (String str : digit.subList(1, digit.size())) {
                List<String> aw = new ArrayList<>();
                for (String s: ss) {
                    for (char c : str.toCharArray()) {
                        aw.add(s + String.valueOf(c));
                    }
                }
                ss = aw;
            }
        }
        System.out.println(ss);
        return ss;
    }
}