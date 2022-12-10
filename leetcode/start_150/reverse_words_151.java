package one_five_zero_plus;

/**
 * 进阶版要求使用O（1）的额外空间，可以采用双指针法逐个调换首尾的字符，再逐个删除空格，但同时要注意单词的内容也完全调换了
 * 所以要逐渐再反转回来，这样做不好的地方在于产生额外的时间开销
 */

public class reverse_words_151 {
    public static void main(String[] args) {
        String ss = "  hello world  ";
        reverse_words_151 reverseWords151 = new reverse_words_151();
        reverseWords151.reverseWords(ss);
    }
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        for (String s1 : split) {
            System.out.println(s1.length());
        }
        StringBuffer res = new StringBuffer();
        for (int i = split.length - 1; i >= 0; i--){
            if (split[i].length() == 0){
                continue;
            }
            res.append(split[i]);
            res.append(" ");
        }
        String re = null;
        if (res.charAt(res.length() - 1) == ' '){
            re = res.toString().substring(0, res.length() - 1);
        }
        return re;
    }
}
