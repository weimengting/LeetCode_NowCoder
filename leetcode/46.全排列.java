package BackTrace;

//回溯算法，在这里stack用来充当记录路径，used用来存放同一分支下是否已经遍历过

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FullArrange_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new FullArrange_46().permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, stack, list);
        return list;
    }

    public void dfs(int[] nums, boolean[] used, Stack<Integer> stack, List<List<Integer>> res){
        if (stack.size() == nums.length){
            System.out.println(stack);
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i ++){
            if (used[i] == false){
                used[i] = true;
                stack.add(nums[i]);
                dfs(nums, used, stack, res);
                used[i] = false;
                stack.pop();
            }
        }
    }
}
