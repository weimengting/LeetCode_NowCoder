package start_100;

/**
 * 对二叉树问题的递归解法做个总结：
 *              1.在递归内部，先确定终止条件（即return的出口）
 *              2.确定单科树的根节点
 *              3.左分支和右分支进入循环
 *              4.重点在于参数的设置，这决定了上一递归到下一递归的传递条件
 */

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree2_106 {
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }
        int n = postorder.length;
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight){
        if (postorderLeft > postorderRight){
            return null;
        }
        //后序遍历中的最后一个节点就是根节点（根节点对应的索引）
        int postorderRoot = postorderRight;
        //在中序遍历中定位根节点
        int inorderRoot = map.get(postorder[postorderRoot]);
        TreeNode root = new TreeNode();
        root.val = postorder[postorderRoot];
        //右子树中的节点数目
        int size_right_subtree = inorderRight - inorderRoot;

        root.left = myBuildTree(inorder, postorder,
                inorderLeft, inorderRoot - 1, postorderLeft, postorderRoot - size_right_subtree - 1);
        root.right = myBuildTree(inorder, postorder,
                inorderRoot + 1, inorderRoot + size_right_subtree, postorderRoot - size_right_subtree, postorderRoot - 1);
        return root;
    }
}
