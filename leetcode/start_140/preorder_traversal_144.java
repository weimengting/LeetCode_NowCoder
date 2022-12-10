package one_four_zero_plus;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
    前序遍历，先把中间的放进去，随后向左遍历，左中，左，右。。。
 */
public class preorder_traversal_144 {

    // Solution 1. 递归求解
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> res, TreeNode root){
        if (root == null){
            return;
        }
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }

    //Solution 2. 迭代求解
    public List<Integer> preorderTraversal2(TreeNode root){

        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        // 新命名一个指针为cur，指向root不同节点的地址，而root本身不变
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            // 一直在左边遍历，直到没有叶子
            while (cur != null){
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}
