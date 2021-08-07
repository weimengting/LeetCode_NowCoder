package start_30;

//回溯算法，非重复元素，used数组用来存放是否已经放过

import java.util.*;

public class Group_sum2_40 {
    public static void main(String[] args) {
        int[] cand = {1,2};
        int target = 4;
        Solution_40 solution_40 = new Solution_40();
        solution_40.combinationSum2(cand, target);
    }
}

class Solution_40 {
    private static Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        int[] used = new int[candidates.length];
        dfs(list, candidates, target, 0, 0, used);
        System.out.println(list);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] candidates, int target, int sum, int ind, int[] used){
        if (sum == target){
            List<Integer> temp = new ArrayList<>(stack);
            Collections.sort(temp);
            if (!list.contains(temp)){
                list.add(temp);
            }
            return;
        }

        for (int i = ind; i < candidates.length; i ++){
            if (sum + candidates[i] > target){
                break;
            }
            if (used[i] == 1){
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0){
                continue;
            }

            stack.add(candidates[i]);
            used[i] = 1;
            dfs(list, candidates, target, sum + candidates[i], ind + 1, used);
            used[i] = 0;
            stack.pop();
        }

    }
}
