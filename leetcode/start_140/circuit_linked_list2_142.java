package one_four_zero_plus;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class circuit_linked_list2 {

    public ListNode detectNode(ListNode node){
        Set<ListNode> seen = new HashSet<>();

        while (node != null){
            if (!seen.add(node)){
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
