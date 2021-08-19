package start_60;

/**
 * carry = temp / 10;
 * int repl = temp % 10;
 * 分别用来记录进位和该位的值
 */

public class AddOne_66 {
    public static void main(String[] args) {
        int[] digits = {0};
        new AddOne_66().plusOne(digits);
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0;
        int temp = digits[len - 1];
        for (int i = len - 1; i >= 0; i --){
            if (i == len - 1){
                temp = digits[i] + 1 + carry;
            }
            else {
                temp = digits[i] + carry;
            }
            carry = temp / 10;
            int repl = temp % 10;
            digits[i] = repl;
        }
        int[] res = new int[len + 1];
        if (carry > 0){
            res[0] = carry;
            for (int i = 1; i < res.length; i ++){
                res[i] = digits[i - 1];
            }
        }
        for (int digit : digits) {
            System.out.println(digit);
        }
        return carry > 0 ? res : digits;
    }
}
