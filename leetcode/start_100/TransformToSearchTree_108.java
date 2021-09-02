package start_100;

import common.TreeNode;

public class TransformToSearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode root = new TreeNode();
        root.val = nums[middle];
        root.left = dfs(nums, start, middle - 1);
        root.right = dfs(nums, middle + 1, end);
        return root;
    }
}
