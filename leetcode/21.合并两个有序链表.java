//对应第21题，没什么理解上的困难，注意collection的排序用法



import java.util.*;

public class merge_sorted_lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        l1.next = new ListNode(); l1.next.val = 2;
        l1.next.next = new ListNode(); l1.next.next.val = 4;
        ListNode l2 = new ListNode();
        l2.val = 1;
        l2.next = new ListNode(); l2.next.val = 3;
        l2.next.next = new ListNode(); l2.next.next.val = 4;
        Solution_lp rt = new Solution_lp();
        rt.mergeTwoLists(l1, l2);
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution_lp {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode result = new ListNode(), cur = result;
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i ++) {
            cur.val = list.get(i);
            if (i != list.size() - 1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println(result.next.next.next.next.next.next.val);
        return result;
    }
}