package start_110;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinDepth_111 {
    //迭代法，如果遇到没有左右节点的叶子，返回深度
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (true){
            List<TreeNode> temp = new ArrayList<>();
            while (!queue.isEmpty()){
                temp.add(queue.poll());
            }

            for (TreeNode treeNode : temp) {
                if (treeNode.right == null && treeNode.left == null){
                    return count;
                }
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


    //递归法，更简洁效率更高,注意如果根节点的左或右子树为空的话是构不成子树的。而最小深度是要求从根节点到子树的。当左或右子树为空时，不符合要求
    public int minDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right != null){
            return minDepth2(root.right) + 1;
        }
        if (root.right == null && root.left != null){
            return minDepth2(root.left) + 1;
        }
        return Math.min(minDepth2(root.left),minDepth2(root.right)) + 1;
    }
}
