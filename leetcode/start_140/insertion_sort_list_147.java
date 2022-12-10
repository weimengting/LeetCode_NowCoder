package one_four_zero_plus;

import common.ListNode;

/**
 * 1. 定义一个已经排好顺序的尾结点用来维护
 * 2. 定义当前节点为尾结点的下一个节点
 * 3. 当当前节点的值不满足顺序时，从头开始遍历，并插入到对应位置中
 * 4. 满足顺序，将已排好的部分拉长（将当前元素放入）
 */

public class insertion_sort_list_147 {
    public ListNode solution(ListNode head){
        if (head == null){
            return null;
        }
        // lastSorted 为维护的已排序的列表的最后一个节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = lastSorted.next;
        while (curr != null){
            if (lastSorted.val <= curr.val){
                lastSorted = lastSorted.next;
            }
            else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val){
                    prev = prev.next;
                }
                // 如果遍历到不合理的情况，则将节点插入到该位置
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    private void reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            curr.next = prev;
            prev = curr;
            curr = curr.next;

        }
    }

}
