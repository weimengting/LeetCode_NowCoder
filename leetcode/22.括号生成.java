//递归的方法不是我这种凡人能够理解的，还是尝试暴力法吧
//排列组合的代码也很烧脑，实在不行就熟读背诵



import java.util.*;


public class Generate_Parentheses_22 {
    public static void main(String[] args) {
//        Solution22 de = new Solution22();
//        de.generateParenthesis(3);

        Solution_brute_force dr = new Solution_brute_force();
        List result = dr.generateParenthesis(3);
        System.out.println(result);
    }
}

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        dfs(result, n, "", 0, 0);
        return result;
    }

    private void dfs(List<String> result, int n, String str, int left, int right) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left > n || right > n || left < right) {
            return;
        }
        dfs(result, n, str + "(", left + 1, right);
        dfs(result, n, str + ")", left, right + 1);
    }
}

class Solution_brute_force {
    public StringBuilder stack = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        String[] brackets = {"(", ")"};
        List<String> combinations = new ArrayList();
        generateAll(brackets, n * 2, 0, combinations, stack);
        return combinations;
    }

    public void generateAll(String[] brackets, int targ, int cur, List<String> result, StringBuilder cur_string) {

        if (cur == targ) {
            if (valid(cur_string))
                result.add(cur_string.toString());
        } else {
            for (String c : brackets) {
                stack.append(c);
                generateAll(brackets, targ, cur + 1, result, stack);
                stack.delete(stack.length() - 1, stack.length());
            }
        }
    }

    public boolean valid(StringBuilder current) {
        int balance = 0;
        for (char c: current.toString().toCharArray()) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}