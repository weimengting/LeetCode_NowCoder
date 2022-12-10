package one_four_zero_plus;

import common.ListNode;
// 递归的出口很重要，分冶算法可以认为是回溯的一种形式

public class sort_list_148 {
    public ListNode solution(ListNode head){
        return solution(head, null);
    }

    public ListNode solution(ListNode head, ListNode tail){
        if (head == null){
            return head;
        }

        if (head.next == tail){
            // 说明此时已经到了递归出口，需要将head转换为单个节点，然后与另外的合并
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = solution(head, mid);
        ListNode list2 = solution(mid, tail);
        return merge(list1, list2);
    }

    // 合并两个有序列表
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyNode = new ListNode(0);
        ListNode tmp = dummyNode, tmp1 = head1, tmp2 = head2;
        while (tmp1 != null && tmp2 != null){
            if (tmp1.val <= tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if (tmp1 != null){
            tmp.next = tmp1;
        }else if (tmp2 != null){
            tmp.next = tmp2;
        }
        return dummyNode.next;
    }
}
