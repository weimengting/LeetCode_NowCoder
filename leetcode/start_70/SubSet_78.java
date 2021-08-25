package start_70;

//一种思路是继承上一题回溯的思想
//可以采用类似于动态规划的思路：每增加一个元素，原来所有的子集都叠加上这个新增的元素（同时包括原来的子集）

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubSet_78 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 5};
        new SubSet_78().subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        res.add(new ArrayList<>());
//        for (int i = 0; i < nums.length; i ++){
//            List<Integer> temp = new ArrayList<>();
//            temp.add(nums[i]);
//            res.add(temp);
//        }
        for (int k = 1; k <= nums.length; k ++){
            dfs(nums, k, res, stack, 0);
            //stack = new Stack<>();
        }
        System.out.println(res);
        return res;
    }
    private void dfs(int[] nums, int k, List<List<Integer>> res, Stack<Integer> stack, int begin){
        if (stack.size() == k){
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i < nums.length; i ++){
            stack.push(nums[i]);
            dfs(nums, k, res, stack, i + 1);
            stack.pop();
        }
    }
}
