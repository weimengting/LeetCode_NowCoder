package one_four_zero_plus;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class posterorder_traversal_145 {
    // Solution 1. 递归法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        posterorder(res, root);
        return res;
    }

    private void posterorder(List<Integer> res, TreeNode root){
        if (root == null){
            return;
        }

        posterorder(res, root.left);
        posterorder(res, root.right);
        res.add(root.val);
    }
    // Solution 2. 迭代法
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            // 每到达一个节点就一直遍历到最左边的节点
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 当右边为空或者是右边已经存入的时候，说明此时的节点可以存入（要么为左节点，要么为中间节点）
            if (root.right == null || root.right == prev){
                res.add(root.val);
                prev = root;
                root = null;
            }
            // 当右边有值时，应该先遍历到没有的情况（在此基础上遍历左边）
            else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
