package start_90;

//回溯法，注意剪枝
//Java8的新特性stream方法：stack.stream().collect(Collectors.joining("."))

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RestoreIP_93 {
    public static void main(String[] args) {
        new RestoreIP_93().restoreIpAddresses("010010");
        Stack<String> stack = new Stack<>();
        stack.add("234");
        stack.add("12");
        String f = stack.stream().collect(Collectors.joining("."));
        System.out.println(f);
    }
    public Stack<String> stack = new Stack<>();
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4){
            return res;
        }
        dfs(s, stack, res);
        System.out.println(res);
        return res;
    }

    private void dfs(String cur_str, Stack<String> stack, List<String> res){
        if (stack.size() == 4){
            if (cur_str.length() == 0){
                res.add(stack.stream().collect(Collectors.joining(".")));
            }
            return;
        }

        for (int i = 1; i <= cur_str.length(); i ++){
            String left = cur_str.substring(0, i);
            String right = cur_str.substring(i);
            if (left.length() > 3){
                break;
            }
            if (left.length() > 1 && left.charAt(0) == '0'){
                continue;
            }
            if (Integer.parseInt(left) > 255){
                continue;
            }

            stack.add(left);
            dfs(right, stack, res);
            stack.pop();
        }
    }
}
