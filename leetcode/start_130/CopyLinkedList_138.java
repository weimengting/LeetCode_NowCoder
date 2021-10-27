package start_130;

//编程要素：如果你的程序在你觉得尚未优化好的时候跑起来了，那就不要动它
//这种带链表的题目很多还是有迹可循的

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CopyLinkedList_138 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node clone = new Node(head.val);
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        map.put(head, clone);
        queue.offer(head);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();

            Node ne = tmp.next;
            if (ne == null){
                map.get(tmp).next = null;
            }
            else if (!map.containsKey(ne)){
                map.put(ne, new Node(ne.val));
                queue.offer(ne);
            }

            Node ran = tmp.random;
            if (ran == null){
                map.get(tmp).random = null;
            }
            else if (!map.containsKey(ran)){
                map.put(ran, new Node(ran.val));
                queue.offer(ran);
            }
            map.get(tmp).next = map.get(ne);
            map.get(tmp).random = map.get(ran);
        }
        return clone;
    }


    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


