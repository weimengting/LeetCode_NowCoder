package start_80;

import common.ListNode;
import start_70.DeleteRepeat_80;

import java.util.*;

public class DeleteRepeation_82 {
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
        List<Integer> temp = new ArrayList<>();
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null){
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1){
                temp.add(integer);
            }
        }
        if (temp.size() == 0){
            return null;
        }
        Collections.sort(temp);
        ListNode res = new ListNode(), cur = res;
        for (int i = 0; i < temp.size(); i ++){
            cur.val = temp.get(i);
            if (i != temp.size() - 1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return res;
    }
}
