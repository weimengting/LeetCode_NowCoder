package start_50;

public class LengthOfLastWord_58 {
    public static void main(String[] args) {
        new LengthOfLastWord_58().lengthOfLastWord("   fly me   to   the moon  ");
    }
    public int lengthOfLastWord(String s) {
        StringBuffer sp = new StringBuffer(s);
        sp = sp.reverse();
        String[] split = sp.toString().split(" ");
        for (String s1 : split) {
            if (s1.length() > 0){
                return s1.length();
            }
        }
        return 0;
    }
}
