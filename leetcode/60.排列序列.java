package BackTrace;

//转眼间又是两个小时过去了
/**
 * 直接排列组合会超时，加了剪枝也会超时，官方给出的做法是根据给出的k初步定位到起点位置
 * 从起点位置开始遍历，回溯过程中如果计数达到要求直接break，可以节省时间
 */

import java.util.*;

public class ArrangeSequence_60 {
    public List<Integer> list = new ArrayList<>();
    public Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        new Solution_60().getPermutation(4, 9);
    }
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(0, n, stack, k, list, res);
        String s = "";
        for (Integer integer : res) {
            s += String.valueOf(integer);
        }
        System.out.println(s);
        return s;
    }

    public void dfs(int cur_len, int n, Stack<Integer> used, int k, List<Integer> list, List<Integer> res){


        if (cur_len == n){
           list.add(1);
            if (list.size() == k){
                for (Integer integer : used) {
                    res.add(integer);
                }
            }
           return;
        }

        for (int i = 1; i <= n; i ++){
            if (list.size() == k){
                break;
            }
            if (used.contains(i)){
                continue;
            }
            used.add(i);
            dfs(cur_len + 1, n, used, k, list, res);
            used.pop();
        }
    }
}

class Solution_60{
    public List<Integer> list = new ArrayList<>();
    public Stack<Integer> stack = new Stack<>();
    public String getPermutation(int n, int k){
        List<Integer> record = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        //计算阶乘
        int start = 1;
        for (int i = n - 1; i > 0; i --){
            start =start * i;
        }
        //System.out.println(start);  //(n-1)等于多少
        int extra = k / start;    //查看第一个位置已经放过多少数
        //System.out.println(extra);
        int start_ind = (k % start == 0) ? extra : extra + 1;
        List<Integer> candis = new ArrayList<>();
        for (int i = 1; i <= n; i ++){
                if (i != start_ind){
                    candis.add(i);
                }
            }
        //System.out.println(candis);
        System.out.println(start_ind);
        int left = (k % start == 0) ? k - (k / start - 1) * start : k - (k / start) * start;
        //System.out.println(left);
        dfs(0, candis, stack, left, record, res);
        System.out.println(res);
        String s = String.valueOf(start_ind);
        for (Integer re : res) {
            s += String.valueOf(re);
        }
        System.out.println(s);
        return s;
    }
    public void dfs(int cur_len, List<Integer> candis, Stack<Integer> used, int k, List<Integer> list, List<Integer> res){

        if (cur_len == candis.size()){
            list.add(1);
            if (list.size() == k){
                for (Integer integer : used) {
                    res.add(integer);
                }
            }
            return;
        }

        for (int i = 1; i <= candis.size(); i ++){
            if (list.size() == k){
                break;
            }
            if (used.contains(candis.get(i - 1))){
                continue;
            }
            used.add(candis.get(i - 1));
            dfs(cur_len + 1, candis, used, k, list, res);
            used.pop();
        }
    }

}
