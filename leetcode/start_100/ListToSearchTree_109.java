package start_100;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ListToSearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null){
            return null;
        }
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return dfs(list, 0, list.size() - 1);
    }

    private TreeNode dfs(List<Integer> nums, int start, int end){
        if (start > end){
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode root = new TreeNode();
        root.val = nums.get(middle);
        root.left = dfs(nums, start, middle - 1);
        root.right = dfs(nums, middle + 1, end);
        return root;
    }
}
