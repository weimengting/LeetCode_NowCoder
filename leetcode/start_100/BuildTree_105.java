package start_100;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {
    //哈希表中存放中序遍历中元素的值->对应的坐标
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }
        int n = preorder.length;
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
        if (preorderLeft > preorderRight){
            return null;
        }
        //前序遍历中的第一个节点就是根节点（根节点对应的索引）
        int preorderRoot = preorderLeft;
        //在中序遍历中定位根节点
        int inorderRoot = map.get(preorder[preorderRoot]);
        TreeNode root = new TreeNode();
        root.val = preorder[preorderRoot];
        //左子树中的节点数目
        int size_left_subtree = inorderRoot - inorderLeft;

        root.left = myBuildTree(preorder, inorder,
                preorderLeft + 1, preorderLeft + size_left_subtree, inorderLeft, inorderRoot - 1);
        root.right = myBuildTree(preorder, inorder,
                preorderLeft + size_left_subtree + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }
}
