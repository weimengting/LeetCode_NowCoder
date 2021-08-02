//对应第23题，没有难度，虽然标识是hard
//注意控制末尾节点不要随便加零

import java.util.*;
import listnode.ListNode;


public class Merge_k_Sorted_Lists_23 {
    public static void main(String[] args) {
        ListNode a = new ListNode();
        a.val = 1; a.next = new ListNode();
        a.next.val = 3; a.next.next = new ListNode();
        a.next.next.val = 4;
        ListNode b = new ListNode();
        b.val = 1; b.next = new ListNode();
        b.next.val = 4; b.next.next = new ListNode();
        b.next.next.val = 5;
        ListNode[] lio = {a, b};
        Solution_23 ni = new Solution_23();
        ListNode res = ni.mergeKLists(lio);

    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

class Solution_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        ListNode result = new ListNode(), cur = result;
        for (ListNode ln : lists) {
            list = count_len(ln, list);
        }
        Collections.sort(list);
        if (list.size() == 0) return null;
        for (int i = 0; i < list.size(); i ++) {
            cur.val = list.get(i);
            if (list.size() - i != 1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println(list);
        return result;
    }

    public List count_len(ListNode ln, List curr_list) {

        while (ln != null) {
            curr_list.add(ln.val);
            ln = ln.next;
        }
        return curr_list;
    }
}
