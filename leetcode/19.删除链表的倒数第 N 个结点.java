//难点在于考虑各种情况if (len - count == 1 && n == 1) {break;}用于排除最后一个是待删除项的情况，在这种情况下
//不要再增加节点，对应leetcode第19题



public class delete_list_node {
    public static void main(String[] args) {
        ListNode dr = new ListNode();
        dr.val = 1;
        dr.next = new ListNode(); dr.next.val = 2;
        dr.next.next = new ListNode(); dr.next.next.val = 3;
//        dr.next.next.next = new ListNode(); dr.next.next.next.val = 4;
//        dr.next.next.next.next = new ListNode(); dr.next.next.next.next.val = 5;
        Solution_ln gh = new Solution_ln();
        gh.removeNthFromEnd(dr, 1);
        gh.cal_len(dr);
    }
}


//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

class Solution_ln {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(), cur = dummy;
        int count = 0;
        int len = cal_len(head);
        if (cal_len(head) == 1 && n == 1) {return null;}
        while (head != null) {
            count ++;
            if ((len - count + 1) != n) {
                cur.val = head.val;
                if (len - count == 1 && n == 1) {break;}
                else if (count < len) {
                    cur.next = new ListNode();
                    cur = cur.next;
                }
            }
            head = head.next;
        }

        //System.out.println(dummy.next.next.next.val);
        System.out.println(dummy.next.next.val);

        return dummy;
    }

    public int cal_len(ListNode kl) {
        int len = 0;
        while (kl != null) {
            len ++; kl = kl.next;
        }
        return len;
    }
}