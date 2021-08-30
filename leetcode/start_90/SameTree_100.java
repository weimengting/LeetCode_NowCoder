package start_90;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SameTree_100 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = new TreeNode();
        tree.left.val = 2;

        TreeNode tree2 = new TreeNode();
        tree2.val = 1;
        tree2.right = new TreeNode();
        tree2.right.val = 2;
        new SameTree_100().test(tree2);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        else if (p == null || q == null){
            return false;
        }
        else if (p.val != q.val){
            return false;
        }
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    private void test(TreeNode p){
        List<Integer> list = new ArrayList<>();
        dfs(p, list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    private void dfs(TreeNode treeNode, List<Integer> list){
        if (treeNode == null){
            list.add(null);
            return;
        }

        list.add(treeNode.val);
        dfs(treeNode.left, list);
        dfs(treeNode.right, list);
    }

}
