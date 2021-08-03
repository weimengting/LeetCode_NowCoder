package start_30;

//贴一个大佬的答案
//括号问题用堆栈解决
//用栈模拟一遍，将所有无法匹配的括号的位置全部置1
//例如: "()(()"的mark为[0, 0, 1, 0, 0]
//再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
//经过这样的处理后, 此题就变成了寻找最长的连续的0的长度


import java.util.Stack;

public class valid_path_32 {
    public static void main(String[] args) {
        Solution_32 fr = new Solution_32();
        int ty = fr.longest(")()((())");
        System.out.println(ty);
    }

}

class Solution_32 {
    public int longest(String s){
        Stack<Integer> stack = new Stack<>();
        int[] mark = new int[s.length()];
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                if (stack.isEmpty()){
                    mark[i] = 1;
                }
                else{
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            mark[stack.peek()] = 1;
            stack.pop();
        }
        int len = 0;
        int res = 0;
        for (int i = 0; i < mark.length; i ++){
            if (mark[i] == 0){
                len ++;
            }
            else{
                res = Math.max(len, res);
                len = 0;
            }
        }
        res = Math.max(len, res);
        return res;
    }
}
