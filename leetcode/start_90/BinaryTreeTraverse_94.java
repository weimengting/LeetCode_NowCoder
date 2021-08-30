package start_90;

import common.TreeNode;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraverse_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();root.left.val = 2;
        root.right = new TreeNode();root.right.val = 3;
        root.left.left = new TreeNode();root.left.right = new TreeNode();
        root.left.left.val = 4;root.left.right.val = 5;
        root.right.left = new TreeNode();
        root.right.left.val = 6;
        new BinaryTreeTraverse_94().inorderTraversal(root);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        System.out.println(res);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root){
        if (root == null){
            return;
        }

        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }
}
