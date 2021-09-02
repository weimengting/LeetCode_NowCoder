package start_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepth_104 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 3;
        tree.left = new TreeNode();
        tree.left.val = 9;
//        tree.left.left = new TreeNode();
//        tree.left.left.val = 13;
//        tree.left.right = new TreeNode();
//        tree.left.right.val = 14;

        tree.right = new TreeNode();
        tree.right.val = 20;
//        tree.right.left = new TreeNode();
//        tree.right.left.val = 15;
//        tree.right.right = new TreeNode();
//        tree.right.right.val = 7;
        int res = new MaximumDepth_104().maxDepth(tree);
        System.out.println(res);
    }
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return 0;
        }
        queue.offer(root);
        int count = 1;
        while (true){
            if (queue.isEmpty()){
                return count - 1;
            }
            List<TreeNode> temp = new ArrayList<>();
            while (!queue.isEmpty()){
                temp.add(queue.poll());
            }
            for (TreeNode treeNode : temp) {
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
            count ++;
        }
    }
}
