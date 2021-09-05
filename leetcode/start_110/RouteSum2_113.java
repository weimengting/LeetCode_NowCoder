package start_110;

import common.TreeNode;

import java.util.*;

public class RouteSum2_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root == null){
            return res;
        }

        dfs(root, targetSum, res, stack, stack2);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> list, Stack<Integer> stack, Stack<TreeNode> stack2){
        if (root.left == null && root.right == null){
            stack.push(root.val);
            stack2.push(root);
            if (stack.stream().mapToInt(x -> x).sum() == targetSum){
                List<Integer> temp = new ArrayList<>(stack);
                list.add(temp);
            }
            stack.pop();
            stack2.pop();
            return;
        }
        if (!stack2.contains(root)){
            stack2.push(root);
            stack.push(root.val);
            if (root.left != null){
                dfs(root.left, targetSum, list, stack, stack2);
            }
            if (root.right != null){
                dfs(root.right, targetSum, list, stack, stack2);
            }
            stack.pop();
            stack2.pop();
        }
    }
}

//复杂度太高，进行优化（看看人家答案写的，再看看你写的：）

class Solution {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        if (root.left == null && root.right == null && targetSum == 0){
            ret.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.pollLast();
    }
}
