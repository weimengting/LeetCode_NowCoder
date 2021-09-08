package start_120;

public class ValidatePalindrome_125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0){
            return true;
        }
        StringBuilder sp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)){
                sp.append(Character.toLowerCase(c));
            }
        }
        int start = 0;
        int end = sp.length() - 1;
        while (start < end){
            if (sp.charAt(start) != sp.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
