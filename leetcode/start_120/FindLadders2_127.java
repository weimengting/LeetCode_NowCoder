package start_120;

import java.util.*;

public class FindLadders2_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 利用 BFS 得到所有的邻居节点,以及每个节点的所在层数
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map, distance);
        ArrayList<String> temp = new ArrayList<String>();
        // temp 用来保存当前的路径
        temp.add(beginWord);
        //回溯法（深度优先搜索）
        findLaddersHelper(beginWord, endWord, map, distance, temp, ans);
        return ans.isEmpty() ? 0 : ans.get(0).size();
    }

    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
                                   HashMap<String, Integer> distance, ArrayList<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        // 得到所有的可能的下一个单词
        /*
      "a"
      "c"
      ["a","b","c"]*/
        //之所以是 map.getOrDefault 而不是 get，就是上边的情况 get 会出错（其中可能没有相应的key）
        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
        for (String neighbor : neighbors) {
            //判断层数是否符合
            if (!ans.isEmpty()){
                break;
            }
            if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
                temp.add(neighbor);
                findLaddersHelper(neighbor, endWord, map, distance, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    //利用bfs得到所有的邻居节点，以及每个节点的所在层数
    public void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map,
                    HashMap<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //distance存放的是该单词所对应的在整棵树中第一次出现的层数
        distance.put(beginWord, 0);
        boolean isFound = false;
        int depth = 0;
        //将wordList存放到一个集合中
        Set<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth ++;
            //遍历队列中的所有元素
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                // 一次性得到该单词所对应的wordList中的所有的下一个单词
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                //map存放的是当前单词 -> 当前单词在单词表中对应的满足条件的所有可能的下一个单词
                map.put(temp, neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, depth);
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                    }
                }
            }
            if (isFound) {
                break;
            }
        }
    }

    public static ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray(); //将当前单词拆分成字符

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }
}
