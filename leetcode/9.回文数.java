//判断一个整数是否为回型
//整形转化为字符串toString，以及通过StringBuffer进行字符串翻转


public class judge_if_panli {
    public static void main(String[] args) {
        Solution6 exa = new Solution6();
        boolean df = exa.isPalindrome(-101);
        System.out.println(df);
    }
}

class Solution6 {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuffer rev = new StringBuffer(s);
        String s2 = rev.reverse().toString();
        return s.equals(s2);
    }
}