package BackTrace;

//回溯，剪枝学的不太行

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FullArrange2_47 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new FullArrange2_47().permuteUnique(nums);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, stack, list);
        return list;
    }

    public void dfs(int[] nums, boolean[] used, Stack<Integer> stack, List<List<Integer>> res){
        if (stack.size() == nums.length){

            List<Integer> temp = new ArrayList<>(stack);
            if (!res.contains(temp)){
                System.out.println(stack);
                res.add(temp);
            }
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
