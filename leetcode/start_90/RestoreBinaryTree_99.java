package start_90;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RestoreBinaryTree_99 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = new TreeNode();
        tree.left.val = 3;
        tree.left.right = new TreeNode();
        tree.left.right.val = 2;
        new RestoreBinaryTree_99().recoverTree(tree);
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        for (TreeNode treeNode : list) {
            System.out.println(treeNode.val);
        }
        for (int i = 0; i < list.size() - 1; i ++){
            if (list.get(i).val >= list.get(i + 1).val){
                y = list.get(i + 1);             //此时x指向的是root里面该节点所在的位置，相当于x只建立了一个新的指针，x发生改变时，实际上是
                if (x == null) {                  //root中的东西在发生改变
                    x = list.get(i);
                }
            }
        }
        if (x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode treeNode, List<TreeNode> list){
        if (treeNode == null){
            return;
        }

        dfs(treeNode.left, list);
        list.add(treeNode);
        dfs(treeNode.right, list);
    }
}
