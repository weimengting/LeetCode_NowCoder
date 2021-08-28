package start_80;

/**
 * 两种思路：
 *          1. 直接建立两个新的链表，分别直接放入满足两种条件的元素
 *          2. 将元素取出后利用集合实现（效率比较低，但不容易出错）
 */

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SeparateList_86 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;listNode.next = new ListNode();
        listNode.next.val = 4; listNode.next.next = new ListNode();
        listNode.next.next.val = 3; listNode.next.next.next = new ListNode();
        listNode.next.next.next.val = 2; listNode.next.next.next.next = new ListNode();
        listNode.next.next.next.next.val = 5; listNode.next.next.next.next.next = new ListNode();
        listNode.next.next.next.next.next.val = 2;
        new SeparateList_86().partition(listNode, 3);
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        List<Integer> whole = new ArrayList<>();
        while (head != null){
            whole.add(head.val);
            head = head.next;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < whole.size(); i ++){
            if (x > whole.get(i)){
                left.add(whole.get(i));
            }
            else {
                right.add(whole.get(i));
            }
        }

        ListNode listNode = new ListNode(), cur = listNode;
        if (!left.isEmpty() && !right.isEmpty()){
            for (int i = 0; i < left.size(); i ++){
                cur.val = left.get(i);
                cur.next = new ListNode();
                cur = cur.next;
            }
            for (int i = 0; i < right.size(); i ++){
                cur.val = right.get(i);
                if (i != right.size() - 1){
                    cur.next = new ListNode();
                    cur = cur.next;
                }
            }
        }
        else if (!left.isEmpty() && right.isEmpty()){
            for (int i = 0; i < left.size(); i ++){
                cur.val = left.get(i);
                if (i != left.size() - 1){
                    cur.next = new ListNode();
                    cur = cur.next;
                }
            }
        }
        else if (left.isEmpty() && !right.isEmpty()){
            for (int i = 0; i < right.size(); i ++){
                cur.val = right.get(i);
                if (i != right.size() - 1){
                    cur.next = new ListNode();
                    cur = cur.next;
                }
            }
        }
        return listNode;
    }

    //官方版本
    public ListNode partition2(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
