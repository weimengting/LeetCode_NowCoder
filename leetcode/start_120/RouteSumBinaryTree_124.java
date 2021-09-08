package start_120;

import common.TreeNode;

public class RouteSumBinaryTree_124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    //返回值是最大值的原因：从某个根节点向下走时，走到下一个节点时，只能向左或向右走，即在下一个节点上只能走一条路
    private int dfs(TreeNode root){ //整个框架的意义：返回对于某个节点来说，能够获得的最大路径值（走左边还是走右边）
        if (root == null){
            return 0;
        }
        //在这里跟零进行比较的意义：如果某一边的贡献小于零了，就不用走这边的路，所以置为0
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int pathSum = root.val + left + right;
        max = Math.max(pathSum, max);
        return Math.max(left + root.val, right + root.val);
    }
}
