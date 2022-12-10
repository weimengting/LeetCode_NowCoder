package one_five_zero_plus;

import java.util.*;

// 试图手动使用双向链表实现一个栈 ==》失败
// 直接调用栈的API
// 原算法使用时间复杂度为O（1）的方式获取最小值，即设计一个辅助栈，栈顶始终存放的是当前状态下的最小值，每当一个新的元素要加入时
// 就与当前最小值比较，并将新的最小值压入栈顶；而弹出维护的栈的元素时，也应该相应地把当前元素对应的存放于另一个栈的最小值弹出

public class min_stack_155 {
    public static void main(String[] args) {
        min_stack_155 minStack155 = new min_stack_155();
        minStack155.MinStack();
        minStack155.push(-2);
        minStack155.push(0);
        minStack155.push(-3);
        minStack155.getMin();
        minStack155.pop();
        minStack155.top();
        minStack155.getMin();
    }
    static class bidNode{
        int val;
        bidNode prev;
        bidNode next;
        public bidNode(){}
        public bidNode(int _val){
            this.val = _val;
        }
    }
    // 建立一个列表来维护栈
    private int size = 0;
    private bidNode start = new bidNode();
    private bidNode end = new bidNode();
    private bidNode topPoint = start;

    //建立一个树哈希表来排顺序
    private TreeMap<Integer, List<bidNode>> map = new TreeMap<>();

    public void MinStack() {
        start.next = end;
        end.prev = start;
        start.prev = null;
        end.next = null;
    }

    public void push(int val) {
        bidNode curNode = new bidNode(val);
        if (size == 0){
            start.next = curNode;
            curNode.prev = start;
            curNode.next = end;
            end.prev = curNode;
            topPoint = curNode;
        }
        else {
            curNode.next = topPoint;
            curNode.prev = topPoint.prev;
            topPoint.prev = curNode;
            topPoint.prev.next = curNode;
            topPoint = curNode;
        }
        size ++;
        if (map.containsKey(curNode.val)){
            List<bidNode> tmp = map.get(curNode.val);
            tmp.add(curNode);
            map.put(curNode.val, tmp);
        }
        else {
            List<bidNode> tmp = new ArrayList<>();
            tmp.add(curNode);
            map.put(curNode.val, tmp);
        }
    }

    public void pop() {
        // 将对应哈希表中的元素删除
        List<bidNode> tmp = map.get(topPoint.val);
        if (tmp.size() > 0){
            tmp.remove(0);
        }
        if (tmp.size() == 0){
            map.remove(topPoint.val, map.get(topPoint.val));
        }
        // 删除栈顶的元素，即去掉链表中的这个元素
        topPoint.next.prev = topPoint.prev;
        topPoint.prev.next = topPoint.next;
        topPoint = topPoint.next;
        size --;
    }

    public int top() {
        return topPoint.val;
    }

    public int getMin() {
        return map.firstKey();
    }
}

class min_stack2{
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Deque<Integer> deque = new LinkedList<>();

    public void MinStack() {

    }

    public void push(int val) {
        deque.push(val);
        if (map.containsKey(val)){
            int tmp = map.get(val);
            tmp ++;
            map.put(val, tmp);
        }
        else {
            map.put(val, 1);
        }
    }

    public void pop() {
        int tmp = map.get(deque.getFirst());
        if (tmp == 1){
            map.remove(deque.getFirst(), tmp);
        }
        else {
            tmp --;
            map.put(deque.getFirst(), tmp);
        }
        deque.pop();
    }

    public int top() {
        return deque.getFirst();
    }

    public int getMin() {
        return map.firstKey();
    }
}
