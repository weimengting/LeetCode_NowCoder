package BackTrace;

//本来想用回溯算法计算的，奈何没学明白，脑袋转不过来，暂时用动态规划解一解
//原问题：走到数组的最后一个位置需要的最少步数
/**子问题：走到数组的第i个元素需要的最少步数
 * 建立关系：当走到最后一步时，它和前一步的关系：
 * 遍历之前的所有num元素，它一定是从之前的某个元素过来的，在这个元素的基础上将对应的步长加1；
 * 注意一个前提条件：num数组中该位置对应的元素应该大于等于两个位置之间的间隔，才有可能一步到达
 * 寻找所需步数最少的情况
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkipGame_45 {
    public static void main(String[] args) {
        int[] ums = {2,3,0,1,4};
        SkipGame_45 skipGame_45 = new SkipGame_45();
        skipGame_45.jump(ums);
    }
    public int jump(int[] nums) {

        return dp(nums);
    }

    public int dp(int[] nums){
        int[] res = new int[nums.length];

        for (int i = 1; i < res.length; i ++){
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j ++){  //j表示向后撤退几个位置，直到撤退到起点位置
                if (nums[i - j] >= j && nums[i - j] != 0){
                    list.add(res[i - j] + 1);
                }
            }
            Collections.sort(list);
            res[i] = list.get(0);
        }
        for (int re : res) {
            System.out.println(re);
        }
        return res[nums.length - 1];
    }
}
