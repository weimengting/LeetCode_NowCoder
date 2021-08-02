import java.util.*;
import listnode.ListNode;

public class Swap_Nodes_in_Pairs_24 {
    public static void main(String[] args) {
        ListNode a = new ListNode();
        a.val = 1; a.next = new ListNode();
        a.next.val = 3; a.next.next = new ListNode();
        a.next.next.val = 4;
        Solution_24 wo = new Solution_24();
        ListNode dummy = wo.swapPairs(a);
        System.out.println(dummy.next.val);
    }
}

class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode(), cur = dummy;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int temp = 0;
        if (list.size() == 0) return null;
        int[] arr = list.stream().mapToInt(j -> j).toArray();
        for (int i = 0; i < list.size(); i ++) {
            if (i % 2 == 1) {
                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
        for (int i = 0; i < arr.length; i ++) {
            cur.val = arr[i];
            if (arr.length - i != 1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return dummy;
    }
}


