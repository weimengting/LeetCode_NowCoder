package start_90;

/**
 * 暴力递归会超时，长度很大的排列组合很耗时间
 * 动态规划：
 *          关系不复杂，但是不好想
 *          当每添加一个新的元素时，有几种可能出现的情况：
 *          1.该元素自己能组成一个编码，也就是说，添加上第i个元素时，原来的f（i - 1）对应的每种情况都会与它组成新的可能
 *          2.该元素能够与之前的一个元素组成新的编码，也就是说，添加上第i个元素时，原来的f（i - 2）对应的每种情况都会与它组成新的可能
 *          3.当上面两种情况都成立时：f(i) = f(i - 1) + f(i - 2)
 *          4.都不成立则为0
 *          5.对于i = 0的情况，即为空字符串，后面再进行添加时，一定会有一个分隔，因此f(0) = 1
 */


import java.util.*;
import java.util.stream.Collectors;

public class DecodeMethod_91 {
    public static void main(String[] args) {
        new DecodeMethod_91().numDecodings2("11106");
    }

    private static Map<Integer, Character> map = new HashMap<>();
    static {
        char j = 'A';
        for (int i = 1; i <= 26; i++, j++) {
            map.put(i, j);
        }
    }
    //动态规划
    public int numDecodings2(String s){
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = map.containsKey(Integer.parseInt(s.substring(0, 1))) ? 1 : 0;
        for (int i = 2; i < dp.length; i ++){
            if (map.containsKey(Integer.parseInt(s.substring(i - 1, i)))){
                dp[i] += dp[i - 1];
            }

            if (s.charAt(i - 2) != '0' && map.containsKey(Integer.parseInt(s.substring(i - 2, i)))){
                dp[i] += dp[i - 2];
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }
        return dp[dp.length - 1];
    }

    //dfs解法，超时
    public Stack<String> stack = new Stack<>();
    public int numDecodings(String s) {
        List<Integer> list = new ArrayList<>();
        dfs(stack, s, s, list);
        System.out.println(list.size());
        return list.size();
    }

    private void dfs(Stack<String> stack, String cur_str, String s, List<Integer> list){
        if (cur_str.length() == 0){
            String sp = stack.stream().collect(Collectors.joining());
            if (sp.length() == s.length()){
                list.add(1);
            }
            return;
        }

        for (int i = 1; i <= cur_str.length(); i ++){
            String temp = cur_str.substring(i);
            String left = cur_str.substring(0, i);

            if (left.length() > 2){
                continue;
            }
            if (left.length() > 0 && left.substring(0, 1).equals("0")){
                continue;
            }
            if (!map.keySet().contains(Integer.parseInt(left))){
                continue;
            }
            stack.add(left);
            dfs(stack, temp, s, list);
            stack.pop();
        }
    }
}
