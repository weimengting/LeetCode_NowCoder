package one_five_zero_plus;

import common.ListNode;

/**链表 headA 和 headB 的长度分别是 m和 n。假设链表headA 的不相交部分有 a个节点，链表 headB 的不相交部分有 b个节点，两个链表相交的部分有 c节点，则有 a+c=m，b+c=n
 *   如果 a=b，则两个指针会同时到达两个链表相交的节点，此时返回相交的节点；
 * 如果 a 不等于b，则指针pA 会遍历完链表 headA，指针pB 会遍历完链表headB，两个指针不会同时到达链表的尾节点，然后指针pA 移到链表headB 的头节点，
 * 指针 pB 移到链表headA 的头节点，然后两个指针继续移动，在指针pA 移动了 a+c+b 次、指针 pB 移动了 b+c+a次之后，两个指针会同时到达两个链表相交的节点，
 * 该节点也是两个指针第一次同时指向的节点，此时返回相交的节点
 * 不相交的情况也可由上推理
 */

public class get_insertation_node_160 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        ListNode c = new ListNode(8);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a1.next = a2; a2.next = c; c.next = d; d.next = e;
        b1.next = b2; b2.next = b3; b3.next = c;
        get_insertation_node_160 node160 = new get_insertation_node_160();
        node160.getIntersectionNode(a1, b1);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 返回相交的节点的地址,这种方法的问题在于链表A的每一个节点只会与B的当前或者下一个作比较，如果相差很多就不行
        // 注意每次只移动一步
        ListNode tmp1 = headA, tmp2 = headB;
        while (tmp1 != tmp2){
            if (tmp1 == null){
                tmp1 = headB;
            }
            else {
                tmp1 = tmp1.next;
            }
            if (tmp2 == null){
                tmp2 = headA;
            }else {
                tmp2 = tmp2.next;
            }
        }
        return tmp1;
    }
}
