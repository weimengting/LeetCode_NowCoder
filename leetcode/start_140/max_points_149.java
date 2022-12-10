package one_four_zero_plus;

import java.text.DecimalFormat;
import java.util.*;

/**击败了5%，标注为难题，偏应用
 *只要两个点就可以确定一条直线，所以这里需要枚举所有可能的直线，在枚举过程中有坑需要注意
 * 1. 斜率为0或者不存在的情况要单独考虑
 * 2. 两条互相平行的直线，即使斜率相同，直线也不完全相同
 */



public class max_points_149 {
    public static void main(String[] args) {
        int[][] points = {{0,0}, {4,5},{7,8},{8,9},{5,6},{3,4},{1,1}};
        max_points_149 maxPoints149 = new max_points_149();
        maxPoints149.solution(points);

    }
    static class Tuple {
        int x;
        int y;
        public Tuple(int _x, int _y){
            this.x = _x;
            this.y = _y;
        }
    }
    public int solution(int[][] points) {
        int len = points.length;
        if (len <= 2){
            return len;
        }

        Map<String, Set<String>> map = new HashMap<>();
        boolean[] used = new boolean[len];
        Stack<String> stack = new Stack<>();
        dfs(points, stack, used, map);
        System.out.println(map);
        int size = 0;
        for (String s : map.keySet()) {
            int cur_len = map.get(s).size();
            if (cur_len > size){
                size = cur_len;
            }
        }
        for (Map.Entry<String, Set<String>> stringSetEntry : map.entrySet()) {
            System.out.print(stringSetEntry.getKey());
            System.out.print(": ");
            for (String tuple : stringSetEntry.getValue()) {
                System.out.print("[" + tuple.split("_")[0] + ", ");
                System.out.print(tuple.split("_")[1] + "]");
            }
            System.out.println();
        }
        System.out.println(size);
        return size;
    }
    // set是根据地址判断，不是根据值来判断，每次构建一个新的对象时都会有一个新的地址，即使两个对象的值相同，也会认为两个变量不同
    private void dfs(int[][] points, Stack<String> stack, boolean[] used, Map<String, Set<String>> map){
        if (stack.size() == 2){
            String slope;
            if ((Integer.parseInt(stack.get(0).split("_")[1]) - Integer.parseInt(stack.get(1).split("_")[1])) == 0){
                slope = (stack.get(0).split("_")[1]) + "_line_y";
            }
            else if ((Integer.parseInt(stack.get(0).split("_")[0]) - Integer.parseInt(stack.get(1).split("_")[0])) == 0){
                slope = (stack.get(0).split("_")[0]) + "_line_x";
            }
            else {
                int left = Integer.parseInt(stack.get(0).split("_")[1]) - Integer.parseInt(stack.get(1).split("_")[1]);
                int right = Integer.parseInt(stack.get(0).split("_")[0]) - Integer.parseInt(stack.get(1).split("_")[0]);
                double res =  (double) left / right;
                double b = Double.parseDouble(new DecimalFormat("#.000").format(Integer.parseInt(stack.get(1).split("_")[1]) - res * Integer.parseInt(stack.get(1).split("_")[0])));
                slope = "y=" + res + "*x+" + b;
            }
            if (map.containsKey(slope)){
                Set<String> tmp = map.get(slope);
                tmp.addAll(stack);
                map.put(slope, tmp);
            }
            else {
                Set<String> tmp = new HashSet<>(stack);
                map.put(slope, tmp);
            }
            return;
        }
        for (int i = 0; i < points.length; i ++){
            if (used[i]){
                continue;
            }
            String tup = points[i][0] + "_" + points[i][1];
            used[i] = true;
            stack.push(tup);
            dfs(points, stack, used, map);
            stack.pop();
            used[i] = false;
        }

    }
}
