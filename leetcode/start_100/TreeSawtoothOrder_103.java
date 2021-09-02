package start_100;

//画个层数多一点的树形图找找规律

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSawtoothOrder_103 {
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
        new TreeSawtoothOrder_103().zigzagLevelOrder(tree);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        queue.offer(root);
        int loop = 2;
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
            switch (loop){
                case 1 :
                    for (int i = temp.size() - 1; i >= 0; i --){
                        TreeNode treeNode = temp.get(i);
                        if (treeNode.left != null){
                            queue.offer(treeNode.left);
                        }
                        if (treeNode.right != null){
                            queue.offer(treeNode.right);
                        }
                    }
                    loop = 2;
                    break;

                case 2:
                    for (int i = temp.size() - 1; i >= 0; i --){
                        TreeNode treeNode = temp.get(i);
                        if (treeNode.right != null){
                            queue.offer(treeNode.right);
                        }
                        if (treeNode.left != null){
                            queue.offer(treeNode.left);
                        }
                    }
                    loop = 1;
                    break;
            }

        }
        System.out.println(res);
        return res;
    }
}
