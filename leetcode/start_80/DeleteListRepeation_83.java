package start_80;

import common.ListNode;

import java.util.*;

public class DeleteListRepeation_83 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;listNode.next = new ListNode();
        listNode.next.val = 2; listNode.next.next = new ListNode();
        listNode.next.next.val = 2; listNode.next.next.next = new ListNode();
        listNode.next.next.next.val = 3; listNode.next.next.next.next = new ListNode();
        listNode.next.next.next.next.val = 3; listNode.next.next.next.next.next = new ListNode();
        listNode.next.next.next.next.next.val = 5;
        new DeleteRepeation_82().deleteDuplicates(listNode);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        while (head != null){
            set.add(head.val);
            head = head.next;
        }

        if (set.size() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        ListNode res = new ListNode(), cur = res;
        for (int i = 0; i < list.size(); i ++){
            cur.val = list.get(i);
            if (i != list.size() - 1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return res;
    }
    //官方版本
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) { //如果当前节点的值与下一个节点的值相等，则跳过下一个
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
