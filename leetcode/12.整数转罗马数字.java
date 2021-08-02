import java.util.ArrayList;
import java.util.List;

public class interget_to_roman {
    public static void main(String[] args) {
        Solution_in sp = new Solution_in();
        sp.intToRoman(3);
    }
}


class Solution_in {
    public String intToRoman(int num) {
        int[] list_num = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String s = "";
        for (int i = 0; i < list_num.length;) {
            if (num >= list_num[i]) {
                num = num - list_num[i];
                s += rom[i];
            }
            else {
                i ++;
            }
        }
        System.out.println(s);
        return s;

    }
}
