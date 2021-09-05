package start_110;

//可以使用和116题一样的迭代法，这里测一下递归

import common.Node;

public class PaddingPoint2_117 {
    //测试了好几次都出错，情况没有考虑全，如何准确定位到下一个节点？
    //看看别人写的多妙(先遍历右树，再遍历左树)
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        if (root.left != null && root.right != null){
            root.left.next = root.right;
            root.right.next = getNext(root.next);
        }
        if (root.left == null && root.right != null){
            root.right.next = getNext(root.next);
        }
        if (root.right == null && root.left != null){
            root.left = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node root){
        if (root == null){
            return root;
        }
        if (root.left != null){
            return root.left;
        }
        if (root.right != null){
            return root.right;
        }
        if (root.next != null){
            return getNext(root.next);
        }
        return null;
    }
}
