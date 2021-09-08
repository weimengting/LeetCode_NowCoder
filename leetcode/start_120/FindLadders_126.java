package start_120;

import java.util.*;

/**
 * 挣扎了两天还是超时，难题杀我
 * 记录一下答案的思路：
 *                  如果只使用深度优先搜索的方式会出现很多重复路径，比如，如果两条路径中都出现了单词"abc"，那么，在第一条路径中"abc"后面的
 *                  所有单词一定与另一条路径中该单词的后面的所有单词一样，由于题目要求的是最小路径
 *                  其实只需要记录"abc"能出现的最近距离即可，也就是答案里面所用的bfs方法
 */

public class FindLadders_126 {
    public static void main(String[] args) {
        String beginWord = "qa", endWord = "sq";
        String[] wordList = {
                "tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di",
                "hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc",
                "ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};

        List<String> rm = new ArrayList<>();
        for (String s : wordList) {
            rm.add(s);
        }
        new FindLadders_126().findLadders(beginWord, endWord, rm);

    }
    Deque<String> res = new LinkedList<>();
    TreeMap<Integer,List<List<String>>> map = new TreeMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> rs = new ArrayList<>();
        if (!wordList.contains(endWord)){
            return rs;
        }
        wordList.remove(beginWord); // wordList中的每个单词都不一样，有的话就删除，没有就返回false

        boolean[] used = new boolean[wordList.size()];
        dfs(beginWord, beginWord, endWord, wordList, used);
        System.out.println(map);
        if (map.isEmpty()){
            rs.clear();
            return rs;
        }
        rs = map.get(map.firstKey());
        System.out.println(rs);
        return rs;
    }
    private void dfs(String beginWord, String curWord, String endWord, List<String> wordList, boolean[] used){
        if (curWord.equals(endWord)){
            Deque<String> tp = new LinkedList<>(res);
            tp.addFirst(beginWord);
            List<String> temp = new ArrayList<>(tp);
            if (map.containsKey(temp.size())){
                List<List<String>> tr = map.get(temp.size());
                tr.add(temp);
            }
            else {
                List<List<String>> tr = new ArrayList<>();
                tr.add(temp);
                map.put(temp.size(), tr);
            }
            return;
        }

        for (int i = 0; i < wordList.size(); i ++){
            String cur = wordList.get(i);
            if (!map.isEmpty() && map.firstKey() - 1 < res.size()){
                break;
            }
            if (used[i]){
                continue;
            }
            if (!check(cur, curWord)){
                continue;
            }
            res.addLast(cur);
            used[i] = true;
            dfs(beginWord, cur, endWord, wordList, used);
            res.removeLast();
            used[i] = false;
        }
    }

    private boolean check(String cur, String anchor){
        int i = 0;
        int count = 0;
        while (i < cur.length()){
            if (cur.charAt(i) != anchor.charAt(i)){
                count ++;
                if (count > 1){
                    return false;
                }
            }
            i ++;
        }
        return true;
    }
}

class FindLadders__126 {
    public static void main(String[] args) {
        String beginWord = "qa", endWord = "sq";
        String[] wordList = {"qf","lt","lo","as","qa","ba","yb"};
        Set<String> rm = new HashSet<>();
        for (String s : wordList) {
            rm.add(s);
        }
        ArrayList<String> res = getNeighbors(beginWord, rm);
        System.out.println(res);
    }
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return ans;
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
        return ans;
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