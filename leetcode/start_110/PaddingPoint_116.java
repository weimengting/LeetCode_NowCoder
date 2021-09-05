package start_110;

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PaddingPoint_116 {

    //低阶版，不使用常数空间
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
            return root;
        }
        queue.offer(root);
        while (true){
            List<Node> temp = new ArrayList<>();
            while (!queue.isEmpty()){
                temp.add(queue.poll());
            }
            if (temp.isEmpty()){
                break;
            }
            for (Node node : temp) {
                if (node.left != null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            for (int i = 0; i < temp.size() - 1; i ++){
                Node tp = temp.get(i);
                tp.next = temp.get(i + 1);
            }
        }
        return root;
    }

    //递归版,完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点(有左节点就一定有右节点)
    public Node connect2(Node root){
        if (root == null){
            return null;
        }
        if (root.left != null){
            root.left.next = root.right;
            if (root.next != null){
                root.right.next = root.next.left;
            }
        }

        connect2(root.left);
        connect2(root.right);
        return root;
    }
}
