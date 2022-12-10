package one_four_zero_plus;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class circuit_linked_list {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        ListNode pos = node.next;
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        circuit_linked_list cll = new circuit_linked_list();
        boolean res = cll.hasCycle(node);
        System.out.println(res);
    }

    public boolean hasCycle(ListNode node){
        Set<ListNode> seen = new HashSet<>();
        // 如果set里面要存放一个已经有的数据时，seen.add()会返回false
        while (node != null){
            if (!seen.add(node)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
