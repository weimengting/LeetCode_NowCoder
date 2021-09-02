package start_100;

import common.TreeNode;

//迭代法，队列操作
//迭代比递归好理解很多，问题不复杂的情况下用递归，需要复杂分析的时候保险采用迭代

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSequenceOrder_102 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 3;
        tree.left = new TreeNode();
        tree.left.val = 9;
        tree.right = new TreeNode();
        tree.right.val = 20;
        tree.right.left = new TreeNode();
        tree.right.left.val = 15;
        tree.right.right = new TreeNode();
        tree.right.right.val = 7;
        new TreeSequenceOrder_102().levelOrder(tree);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        queue.offer(root);
        while (true){
            List<TreeNode> temp = new ArrayList<>();
            while (!queue.isEmpty()){
                temp.add(queue.poll());
            }
            if (temp.isEmpty()){
                break;
            }
            List<Integer> val = new ArrayList<>();
            for (TreeNode treeNode : temp) {
                val.add(treeNode.val);
            }
            res.add(val);
            for (TreeNode treeNode : temp) {
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
