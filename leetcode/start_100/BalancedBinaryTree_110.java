package start_100;



import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BalancedBinaryTree_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 3;
        root.left = new TreeNode();
        root.right = new TreeNode();
        root.left.val = 9;
        root.right.val = 20;
        root.right.left = new TreeNode();
        root.right.left.val = 15;
        root.right.left.right = new TreeNode();
        root.right.left.right.val = 8;
//        root.right.right = new TreeNode();
//        root.right.right.val = 7;
        boolean res = new BalancedBinaryTree_110().isBalanced(root);
        System.out.println(res);
    }

    //算法复杂度太高，stack和list占用过多的空间
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> count = new ArrayList<>();
        depth(root.left, stack, count);
        System.out.println(count);
        Collections.sort(count);
        int tt1 = count.get(count.size() - 1);
        count.clear();
        depth(root.right, stack, count);
        System.out.println(count);
        Collections.sort(count);
        int tt2 = count.get(count.size() - 1);
        return Math.abs(tt1 - tt2) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private void depth(TreeNode branch, Stack<Integer> stack, List<Integer> count) {
        if (branch == null) {
            count.add(stack.size());
            return;
        }
        stack.push(1);
        depth(branch.left, stack, count);
        stack.pop();

        stack.push(1);
        depth(branch.right, stack, count);
        stack.pop();
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    //直接递归计算树的高度
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

}
