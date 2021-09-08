package start_120;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class NodeSum_129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 4;
        root.left = new TreeNode();
        root.right = new TreeNode();
        root.left.val = 9;
        root.right.val = 0;
        root.left.left = new TreeNode();
        root.left.left.val = 5;
        root.left.right = new TreeNode();
        root.left.left.right = new TreeNode();
        root.left.left.right.val = 3;
        root.left.right.val = 1;
        new NodeSum_129().sumNumbers(root);
    }
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        int rr = 0;
        for (String re : res) {
            rr += Long.parseLong(re);
        }
        return rr;
    }
    Stack<Integer> stack = new Stack<>();
    private void dfs(TreeNode root, List<String> res){
        if (root.left == null && root.right == null){ //说明此时已经到达根节点
            stack.push(root.val);
            String temp = stack.stream().map(String::valueOf).collect(Collectors.joining());
            res.add(temp);
            stack.pop();
            return;
        }

        if (root.left == null){
            stack.push(root.val);
            dfs(root.right, res);
            stack.pop();
        }

        if (root.right == null){
            stack.push(root.val);
            dfs(root.left, res);
            stack.pop();
        }
        if (root.left != null && root.right != null){
            stack.push(root.val);
            dfs(root.left, res);
            dfs(root.right, res);
            stack.pop();
        }
    }
}
