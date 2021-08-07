package start_30;

//while循环会先判断排在前面的条件，递归效率会高一点，但比较烧脑壳

public class Appearance_list_38 {
    public static void main(String[] args) {
        Solution_38 solution_38 = new Solution_38();
        solution_38.countAndSay(5);
    }
}

class Solution_38 {
    public String countAndSay(int n) {
        String num = "1";
        String res = "";
        for (int i = 0; i < n - 1; i ++){
            res = describe(num);
            num = res;
        }
        System.out.println(num);
        return num;
    }

    private String describe(String num){
        String res = "";
        for (int i = 0; i < num.length(); ){
            String temp = sp(num, i);
            res += temp;
            i += Integer.parseInt(temp.substring(0, 1));
        }
        //System.out.println(res);
        return res;
    }

    private String sp(String s, int ind){
        int temp = ind;
        boolean loop = true;

        while (loop && temp < s.length()){
            if (s.charAt(ind) == s.charAt(temp)){
                temp ++;
            }
            else {
                loop = false;
            }
        }
        String result = (temp - ind) + s.substring(ind, ind + 1);
        return result;
    }
}