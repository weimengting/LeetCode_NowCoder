package start_70;

import java.util.*;

public class Combination_77 {
    public static void main(String[] args) {
        new Combination_77().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        Set<List<Integer>> set = new HashSet<>();
        dfs(set, k, n, stack, 1);
        System.out.println(set);
        return new ArrayList<>(set);
    }
    private void dfs(Set<List<Integer>> set, int k, int n, Stack<Integer> stack, int begin){
        if (stack.size() == k){
            List<Integer> temp = new ArrayList<>(stack);
            //Collections.sort(temp);
            set.add(temp);
            return;
        }

        for (int i = begin; i <= n; i ++){
            stack.push(i);
            dfs(set, k, n, stack, i + 1);
            stack.pop();
        }
    }
}
