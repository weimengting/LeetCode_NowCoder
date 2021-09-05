package start_110;

/**
 * Deque（双端队列） 比 Queue（队列）和Stack（堆栈）要更加灵活
 */

import common.TreeNode;

import java.util.*;

public class TreeUnfoldToList_114 {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        Deque<Integer> deque = new LinkedList<>();
        dfs(root, deque);
        System.out.println(deque);
        TreeNode cur = root;
        while (!deque.isEmpty()){
            cur.val = deque.getFirst();
            cur.left = null;
            if (deque.size() > 1){
                cur.right = new TreeNode();
                cur = cur.right;
            }
            deque.removeFirst();
        }
    }

    private void dfs(TreeNode root, Deque<Integer> deque){
        if (root == null){
            return;
        }

        deque.addLast(root.val);
        dfs(root.left, deque);
        dfs(root.right, deque);
    }
}
