package start_110;

import common.TreeNode;

public class RouteSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        boolean t1 = hasPathSum(root.left, targetSum - root.val);
        boolean t2 = hasPathSum(root.right, targetSum - root.val);
        return t1 || t2;
    }
}
