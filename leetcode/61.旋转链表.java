package start_60;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RotateList_61 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;listNode.next = new ListNode();
        listNode.next.val = 2;listNode.next.next = new ListNode();
        listNode.next.next.val = 3;listNode.next.next.next = new ListNode();
        listNode.next.next.next.val = 4;listNode.next.next.next.next = new ListNode();
        listNode.next.next.next.next.val = 5;
        new RotateList_61().rotateRight(listNode, 2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode res = new ListNode(), cur = res;
        ListNode temp = head;
        while (temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int count = list.size();
        int newk = k % count;
        if (newk == 0){
            return head;
        }
        for (int i = 1; i <= newk; i ++){
            list = translation(list);
        }

        while (count > 0){
            cur.val = list.get(0);
            list.remove(0);
            if (list.size() != 0){
                cur.next = new ListNode();
                cur = cur.next;
            }
            count --;
        }
        System.out.println(list);
        System.out.println(res.next.next.next.next.val);
        return res;
    }

    private List<Integer> translation(List<Integer> list){
        List<Integer> res = new ArrayList<>();
        res.add(list.get(list.size() - 1));
        for (int i = 0; i < list.size() - 1; i ++){
            res.add(list.get(i));
        }
        //System.out.println(res);
        return res;
    }

}
