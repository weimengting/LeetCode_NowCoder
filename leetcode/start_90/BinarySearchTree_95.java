package start_90;

/**
 * 二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。
 * 根据上述特点，可以采用动态规划，相邻的结果之间存在这样一种关系：
 *          由于新来的值一定大于之前的值，所以它的位置只能靠右放，即：
 *          1.作为原来的树的根节点（即新形成的树没有右分支，原来的都位于该节点的左分支上）
 *          2.作为原来的树的第一个右边孩子的右节点（此时剩下的分支都要变为该节点的左分支，保证搜索二叉树的条件）
 *          3.。。。以此类推，有多少个右孩子，就有多少可能
 *          4.剩下的分支接在该节点上并作为左分支
 */

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree_95 {
    public static void main(String[] args) {
        new BinarySearchTree_95().generateTrees(2);
    }

    //递归
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            List<TreeNode> res = new ArrayList<>();
            return res;
        }
        System.out.println(dfs(1, n).size());
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end){
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end){
            allTrees.add(null);
             return allTrees;
        }

        //枚举所有可行的树节点
        //其中i为当前节点，leftTrees为左边的树可能具有的根节点的值所对应的所有的alltrees
        //rightTrees为右边的树可能具有的根节点的值
        for (int i = start; i <= end; i ++){
            List<TreeNode> leftTrees = dfs(start, i - 1);
            List<TreeNode> rightTrees = dfs(i + 1, end);

            //将左边的树和右边的树进行拼接
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode curTree = new TreeNode();
                    curTree.val = i;
                    curTree.left = leftTree;
                    curTree.right = rightTree;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }

    //动态规划
    public List<TreeNode> generateTrees2(int n){
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0){
            return pre;
        }
        pre.add(null);

        for (int i = 1; i <= n; i ++){
            List<TreeNode> cur = new ArrayList<>();
            //先添加顶部节点
            for (TreeNode treeNode : pre) {
                TreeNode curNode = new TreeNode();
                curNode.val = i;
                curNode.left = treeNode;
                cur.add(curNode);
                //依次插入到右孩子，右边最多有n个
                for (int j = 0; j <= n; j ++){
                    TreeNode treeCopyy = treeCopy(treeNode), curNo = treeCopyy; //复制一份，防止指针指向的对象（treeNode）改变
                    int k = 0;
                    while (k < j){
                        if (curNo == null){ // 右节点为空时退出循环
                            break;
                        }
                        curNo = curNo.right;
                        k ++;
                    }
                    if (curNo == null){
                        break;
                    }
                    TreeNode tt = curNo.right;
                    curNode = new TreeNode();
                    curNode.val = i;
                    curNode.left = tt;
                    curNo.right = curNode;  //实际上改动的是treeCopy的内容
                    cur.add(treeCopyy);
                }
            }
            pre = new ArrayList<>(cur);
        }
        return pre;
    }

    private TreeNode treeCopy(TreeNode treeNode){
        if (treeNode == null){
            return null;
        }
        TreeNode res = new TreeNode();
        res.val = treeNode.val;
        res.left = treeCopy(treeNode.left);
        res.right = treeCopy(treeNode.right);
        return res;
    }
}
