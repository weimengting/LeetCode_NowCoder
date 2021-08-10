package start_30;

//题真狗。。
//通过转化为字符串和进位carry来操纵加减乘除是防止溢出的好方法


public class Multi_string_43 {
    public static void main(String[] args) {
        Solution_43 solution_43 = new Solution_43();
        solution_43.multiply("9133", "0");
        //System.out.println(Long.MIN_VALUE);

    }
}


class Solution_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        StringBuilder[] res = new StringBuilder[num1.length()];
        for (int i = num1.length() - 1; i >= 0; i --){
            int carry = 0;
            StringBuilder tmp = new StringBuilder();
            char c = num1.charAt(i);
            for (int j = num2.length() - 1; j >= 0; j --){
                tmp.append(((c - '0') * (num2.charAt(j) - '0') + carry) % 10);
                carry = ((c - '0') * (num2.charAt(j) - '0') + carry) / 10;
                if (carry != 0 && j == 0){
                    tmp.append(carry);
                }
            }
            res[i] = tmp.reverse();
        }
        StringBuilder fin = new StringBuilder();

        for (int i = res.length - 1; i >= 0; i --) {
            for (int j = 0; j < res.length - i - 1; j++) {
                res[i] = res[i].append(0);
            }
        }
        for (int i = res.length - 1; i >= 0; i --) {
            fin = accu(fin.reverse(), res[i].reverse());
        }
        System.out.println(fin);
        return fin.toString();
    }

    private StringBuilder accu(StringBuilder tol, StringBuilder cur){
        int carry = 0;
        StringBuilder tmp = new StringBuilder();
        int ind = 0;
        while (true){
            if (ind < tol.length() && ind < cur.length()){
                int ter = (tol.charAt(ind) - '0') + (cur.charAt(ind) - '0') + carry;
                int yu = ter % 10;
                tmp.append(yu);
                carry = ter / 10;
                ind ++;
            }
            else if (ind >= tol.length() && ind < cur.length()){
                int ter = (cur.charAt(ind) - '0') + carry;
                int yu = ter % 10;
                tmp.append(yu);
                carry = ter / 10;
                ind ++;
            }
            else if (ind < tol.length() && ind >= cur.length()){
                int ter = (tol.charAt(ind) - '0') + carry;
                int yu = ter % 10;
                tmp.append(yu);
                carry = ter / 10;
                ind ++;
            }
            else if (carry != 0){
                tmp.append(carry);
                break;
            }
            else {
                break;
            }
        }
        return tmp.reverse();
    }
}