//对应第25题，逆序问题直接从后往前循环解决


import java.util.*;
import listnode.ListNode;
import java.util.stream.Collectors;
import java.lang.String.*;

public class Reverse_Nodes_in_kGroup_25 {
    public static void main(String[] args) {
        ListNode a = new ListNode();
        a.val = 1; a.next = new ListNode();
        a.next.val = 20; a.next.next = new ListNode();
        a.next.next.val = 3; a.next.next.next = new ListNode();
        a.next.next.next.val = 4; a.next.next.next.next = new ListNode();
        a.next.next.next.next.val = 5;

        Solution_25 qw = new Solution_25();
        qw.reverseKGroup(a, 2);

    }
}


class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode(), cur = dummy;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 0) return null;
        int m = list.size() / k;
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < m; i ++) {
            for (int j = k - 1; j >= 0; j--) {
                out.add(list.get(i * k + j));
            }
        }
        for (int i = m * k; i < list.size(); i ++) {
            out.add(list.get(i));
        }
        for (int i = 0; i < out.size(); i ++) {
            cur.val = out.get(i);
            if (out.size() - i != 1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return dummy;
    }
}