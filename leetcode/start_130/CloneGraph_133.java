package start_130;

//开始到图的数据结构了，leetcode的题目总体上感觉还是有顺序的
//图结构更像是二叉树的递进


import java.util.*;

public class CloneGraph_133 {
    public static HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        return dfs(node);
    }

    //深度优先搜索
    public Node dfs(Node node){
        if (map.containsKey(node)){
            return map.get(node);
        }
        //注意：这里不能这样写，否则会使新节点指向旧的地址（原node的neighbors），每个节点必须有自己定义的neighbors
        //Node clone = new Node(node.val, (ArrayList<Node>) node.neighbors);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            Node tmp = dfs(neighbor);
            clone.neighbors.add(tmp);
        }
        return clone;
    }

    public Node bfs(Node node){
        if (node == null){
            return null;
        }
        Map<Node, Node> mp = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        mp.put(node, clone);
        Queue<Node> deque = new LinkedList<>();
        deque.offer(node);
        while (!deque.isEmpty()){
            Node tmp = deque.poll(); //删除并返回队列头部的元素
            for (Node neighbor : tmp.neighbors) {
                if (!mp.containsKey(neighbor)){
                    mp.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    deque.offer(neighbor);
                }
                mp.get(tmp).neighbors.add(mp.get(neighbor));
            }
        }
        return clone;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
