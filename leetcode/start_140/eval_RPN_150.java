package one_four_zero_plus;

import java.util.Stack;

// 找规律

public class eval_RPN_150 {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        eval_RPN_150 evalRpn150 = new eval_RPN_150();
        evalRpn150.evalRPN(tokens);
    }
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        if (tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        int i = 0;
        while (i < tokens.length){
            if (tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("+") || tokens[i].equals("-")){
                String back = stack.pop();
                String front = stack.pop();
                int res = 0;
                if (tokens[i].equals("*")){
                    res = Integer.parseInt(front) * Integer.parseInt(back);
                }
                else if (tokens[i].equals("/")){
                    res = Integer.parseInt(front) / Integer.parseInt(back);
                }
                else if (tokens[i].equals("+")){
                    res = Integer.parseInt(front) + Integer.parseInt(back);
                }
                else if (tokens[i].equals("-")){
                    res = Integer.parseInt(front) - Integer.parseInt(back);
                }
                System.out.println(res);
                stack.push(String.valueOf(res));
            }else {
                stack.push(tokens[i]);
            }
            i ++;
        }
        System.out.println(stack);
        return Integer.parseInt(stack.get(0));
    }
}
