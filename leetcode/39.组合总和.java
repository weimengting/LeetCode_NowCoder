package start_30;

import java.util.*;

public class Group_sum_39 {
    public static void main(String[] args) {
        int[] cand = {2,3,5};
        int target = 8;
        Solution_39 solution_39 = new Solution_39();
        solution_39.combinationSum(cand, target);

    }
}

class Solution_39 {
    private static Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, stack, candidates, target, 0, 0);
        System.out.println(result);
        return result;
    }

    private void dfs(List<List<Integer>> list, Stack<Integer> stack, int[] candidates, int target, int sum, int cur){
        if (sum == target){
            List<Integer> temp = new ArrayList<>(stack);
            Collections.sort(temp);
            if (!list.contains(temp)) {
                list.add(temp);
            }
            return;
        }

        for (int i = cur; i < candidates.length; i ++){
            if (sum + candidates[i] > target){
                return;
            }
            stack.add(candidates[i]);
            dfs(list, stack, candidates, target, sum + candidates[i], cur);
            stack.pop();
        }
    }
}
