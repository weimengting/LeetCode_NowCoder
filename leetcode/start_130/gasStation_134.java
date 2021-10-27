package start_130;

//做出来超时，常规的遍历方法是解决不了大长度问题的
//奇技淫巧见官方解答
//寻找油量的最小值对应的索引

import java.util.ArrayList;
import java.util.List;

public class gasStation_134 {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3, 4, 3};
        new gasStation_134().canCompleteCircuit(gas, cost);

    }
    //有个答案先排除了负数的情况，还是不行
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i ++){
            if (gas[i] >= cost[i]){
                list.add(i);
            }
        }
        for (int i = 0; i < len; i ++){
            if (list.contains(i)) {
                int gasNum = 0;
                int curIndex = i;
                while (true) {
                    gasNum += gas[curIndex] - cost[curIndex];
                    if (gasNum < 0) {
                        break;
                    }
                    curIndex = (curIndex + 1) % len;
                    if (curIndex == i) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    //官方题解：如果i最远能够到达j，那么i到j之间的任意一个节点都不能绕过一圈
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i ++) {
            int gasNum = 0;
            int curIndex = i;
            while (true) {
                gasNum += gas[curIndex] - cost[curIndex];
                if (gasNum < 0) {
                    break;
                }
                curIndex = (curIndex + 1) % len;
                if (curIndex == i) {
                    return i;
                }
            }
            //考虑curIndex已经过了一周之后的情况
            if (curIndex < i){
                return -1;
            }
            i = curIndex;
        }
        return -1;
    }
}
