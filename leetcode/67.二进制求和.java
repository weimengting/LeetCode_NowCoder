package start_60;

//参考66题

public class BinarySum_67 {
    public static void main(String[] args) {
        String a = "1101";
        String b = "1";
        new BinarySum_67().addBinary(a, b);
    }
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        String temp = "";
        if (a.length() < b.length()){
            for (int i = 1; i <= len - a.length(); i ++){
                temp += "0";
            }
            a = temp + a;
        }
        else if (a.length() > b.length()){
            for (int i = 1; i <= len - b.length(); i ++){
                temp += "0";
            }
            b = temp + b;
        }

        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = len - 1; i >= 0; i --){
            int cur = Integer.parseInt(a.substring(i, i + 1)) + Integer.parseInt(b.substring(i, i + 1)) + carry;
            carry = cur / 2;
            res.append(cur % 2);
        }
        if (carry > 0){
            res.append(carry);
        }
        System.out.println(res.reverse().toString());
        return res.reverse().toString();
    }
}
