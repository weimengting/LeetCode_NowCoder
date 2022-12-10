package one_four_zero_plus;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class rearrange_the_list_143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        rearrange_the_list_143 rearrange_the_list_143 = new rearrange_the_list_143();
        // rearrange_the_list_143.reorderList(head);
        rearrange_the_list_143.reverseList(head);
    }
    // 方法1：存入容器中
    public ListNode reorderList(ListNode node){
        // 设置一个指针指向链表的第一个元素
        List<ListNode> values = new ArrayList<>();
        ListNode cur = node;
        while (cur != null){
            values.add(cur);
            cur = cur.next;
        }
        cur = node;
        int end = values.size() - 1;
        int start = 1;
        for (int i = 1; i < values.size(); i ++){
            if (i % 2 != 0){
                cur.next = values.get(end);
                end --;

            }
            else {
                cur.next = values.get(start);
                start ++;
            }
            if (i != values.size() - 1){
                cur = cur.next;
            }
            else {
                cur.next.next = null;
            }
        }
        System.out.println(cur.val);
        System.out.println(cur.next);
        return node;
    }

    // 方法2：寻找链表中点 + 链表逆序 + 合并链表
    public void reorderList2(ListNode node){
        if (node == null){
            return;
        }
        ListNode mid = middleNode(node);
        ListNode l2 = mid.next;
        mid.next = null;
        ListNode reversed = reverseList(l2);
        mergeList(node, reversed);
    }

    public ListNode middleNode(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null){
            // 不停地将curr的当前节点指向上一个节点
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2){
        while (l1 != null && l2 != null){
            ListNode l1_tmp = l1.next;
            ListNode l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
