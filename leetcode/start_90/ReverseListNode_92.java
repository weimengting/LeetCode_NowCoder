package start_90;

import common.ListNode;

//这种题最保险的做法就是将元素都取出来完成题目要求的操作后再放回去

import java.util.ArrayList;
import java.util.List;

public class ReverseListNode_92 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;listNode.next = new ListNode();
        listNode.next.val = 2; listNode.next.next = new ListNode();
        listNode.next.next.val = 3; listNode.next.next.next = new ListNode();
        listNode.next.next.next.val = 4; listNode.next.next.next.next = new ListNode();
        listNode.next.next.next.next.val = 5; listNode.next.next.next.next.next = new ListNode();
        listNode.next.next.next.next.next.val = 6;
        new ReverseListNode_92().reverseBetween(listNode, 2, 4);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        left = left - 1;
        right = right - 1;
        int[] nums = new int[list.size()];
        for (int i = left, j = right; i <= right; i ++, j --){
            nums[i] = list.get(j);
        }
        for (int i = 0; i < nums.length; i ++){
            if (i < left || i > right){
                nums[i] = list.get(i);
            }
        }
        ListNode res = new ListNode(), cur = res;
        for (int i = 0; i < nums.length; i ++){
            cur.val = nums[i];
            if (i != nums.length - 1){
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return res;
    }
}
