package start_130;

import java.util.Arrays;

public class HandoutCandies_135 {
    //贪心算法，局部最优推出全局最优，两次遍历，从左向右和由右向左

    //确定每个左边大于右边的时候应该从后向前遍历，这样才能使用右边的信息（相当于右边已经固定）
    //确定每个右边大于左边的时候应该从前向后遍历。。。

    public int candy(int[] ratings) {
        int num = 0;
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);
        for (int i = 0; i < ratings.length - 1; i ++){
            if (ratings[i + 1] > ratings[i]){
                candys[i + 1] = candys[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i --){
            if (ratings[i - 1] > ratings[i]){
                //注意，此时如果已经满足条件（在前一轮分配糖果时），保持其不动即可
                candys[i - 1] = Math.max(candys[i - 1], candys[i] + 1);
            }
        }
        int sum = Arrays.stream(candys).sum();
        return sum;
    }
}
