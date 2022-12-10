package one_four_zero_plus;

import java.util.*;

/**
 * 1. 缓存容量
 * 2. 最久未使用的数据  ==》如果数据被使用过，则将其推入栈
 */

public class LRU_cache_146 {
    // 创建一个链表类，其中链表的每个元素存放的是一个键值对
    // 每个节点包括四个重点 ==》该节点对应的键值对，该节点指向的上一个节点，该节点指向的下一个节点
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
    // cache 中按照键来查询该键所对应的节点
    // 全局变量可以在内部类和方法中使用
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public void LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        else {
            removeNode(node);
            addToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 如果不存在则创建一个新的，注意这里的新的会将旧的挤掉
        if (node == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity){
                // 得到last的目的是得到其在哈希表中的值
                DLinkedNode last = removeTail();
                cache.remove(last.key);
                --size;
            }
        }
        // 如果存在则更新键值对，同时放到头部，遵循新进使用后出的原则
        else {
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }
    // 头部放的是新进被拿出来的节点，尾部放的是旧的节点
    // 所以当一个节点被使用了之后，就要把它拿到前面去，具体是先把这个位置的去掉，然后转移到头部
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private DLinkedNode removeTail(){
        // last反映的是一个地址，调用remove时，操作的是该地址上对应的节点
        // last指向的仍然是该节点，只不过该节点与原来链表的节点都断开了
        DLinkedNode last = tail.prev;
        removeNode(last);
        return last;
    }
}
