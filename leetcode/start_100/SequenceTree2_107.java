package start_100;

//队列
// LinkedList<List<Integer>> result = new LinkedList<>();里面有个函数是addFirst（相当于逆序存放），这样避免了利用stack再把数据倒一遍

import common.TreeNode;

import java.util.*;

public class SequenceTree2_107 {
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
        tree.right.left = new TreeNode();
        tree.right.left.val = 15;
        tree.right.right = new TreeNode();
        tree.right.right.val = 7;
        new SequenceTree2_107().levelOrderBottom(tree);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> res = new Stack<>();
        List<List<Integer>> rm = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return rm;
        }
        queue.offer(root);
        while (true){
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> list = new ArrayList<>();
            if (queue.isEmpty()){
                break;
            }
            while (!queue.isEmpty()){
                TreeNode tt = queue.poll();
                list.add(tt);
                temp.add(tt.val);
            }
            res.add(temp);
            for (TreeNode treeNode : list) {
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
        }

        while (!res.isEmpty()){
            rm.add(res.peek());
            res.pop();
        }
        System.out.println(rm);
        return rm;
    }
}
