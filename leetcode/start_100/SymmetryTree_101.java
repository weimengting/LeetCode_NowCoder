package start_100;

import common.TreeNode;

//迭代法比递归法一般会消耗更多的空间，效率也更低一点

import java.util.LinkedList;
import java.util.Queue;

public class SymmetryTree_101 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = new TreeNode();
        tree.right = new TreeNode();
        tree.left.val = 2;
        tree.right.val = 2;
        tree.left.left = new TreeNode();
        tree.left.right = new TreeNode();
        tree.left.left.val = 3;
        tree.left.right.val = 4;

        tree.right.left = new TreeNode();
        tree.right.right = new TreeNode();
        tree.right.left.val = 4;
        tree.right.right.val = 3;

        new SymmetryTree_101().isSymmetric(tree);
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    //递归法
    private boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }

    //迭代法
    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()){
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();
            if (u == null && v == null){
                continue;
            }
            if (u == null || v == null){
                return false;
            }
            if (u.val != v.val){
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}
