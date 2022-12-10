package one_five_zero_plus;

import common.TreeNode;

/**
 * 原来的左子节点变成新的根节点
 * 原来的根节点变成新的右子节点
 * 原来的右子节点变成新的左子节点
 */

import java.util.Deque;
import java.util.LinkedList;

public class upside_down_tree_156 {
    public TreeNode upsideDown(TreeNode treeNode){
        if (treeNode == null){
            return treeNode;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(treeNode);
        while (!deque.isEmpty()){
            TreeNode curNode = deque.pop();
            if (curNode.left != null){
                deque.offer(curNode.left);
                curNode.left.left = curNode.right;
                curNode.left.right = curNode;
            }
            if (curNode.right != null){
                deque.offer(curNode.right);
            }
        }
        return treeNode;
    }
}
