package start_90;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinaryTree_98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        for (int i = 0; i < list.size() - 1; i ++){
            if (list.get(i) >= list.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer> list, TreeNode treeNode){
        if (treeNode == null){
            return;
        }

        dfs(list, treeNode.left);
        list.add(treeNode.val);
        dfs(list, treeNode.right);
    }

    private TreeNode treeCopy(TreeNode root){
        if (root == null){
            return root;
        }

        TreeNode treeNode = new TreeNode();
        treeNode.val = root.val;
        treeNode.left = treeCopy(root.left);
        treeNode.right = treeCopy(root.right);
        return treeNode;
    }
}
