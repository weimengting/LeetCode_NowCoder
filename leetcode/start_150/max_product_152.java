package one_five_zero_plus;

import java.util.TreeSet;
// 暴搜会比较容易理解

/**
 * 动态规划：
 * 1. 定义两个max，min数组，分别用于存放考虑当前元素的时候对应的最优解（最大值和最小值），这样做的目的是保证连续性，如果可以不考虑当前元素的话，后面的乘积就不能利用
 *    已有的关系进行递推，因为中间断开了，而最后在取全局最优解的时候，应该是选max中最好的，考虑到逐个递增的情况
 * 2. min用来存放最小值，是为了考虑数组中的负数
 */

public class max_product_152 {
    public static void main(String[] args) {
        int[] nums = {5,6,-3, 4, -3};
        max_product_152 maxProduct152 = new max_product_152();
        // maxProduct152.maxProduct(nums);
        maxProduct152.dynamicPlanning(nums);
        //maxProduct152.maxProduct2(nums);
    }
    public int maxProduct(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        TreeSet<Integer> res = new TreeSet<>();
        int max_value = 0;
        for (int i = 0; i < nums.length; i ++){
            int cur_product = nums[i];
            if (max_value < cur_product){
                max_value = cur_product;
            }
            for (int j = i + 1; j < nums.length; j ++){
                cur_product = cur_product * nums[j];
                if (max_value < cur_product){
                    max_value = cur_product;
                }
            }
        }
        System.out.println(max_value);
        return max_value;
    }

    private int dynamicPlanning(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int[] max_array = new int[nums.length];
        int[] min_array = new int[nums.length];
        max_array[0] = nums[0];
        min_array[0] = nums[0];
        for (int i = 1; i < nums.length; i ++){
            int tmp1 = Math.max(max_array[i - 1] * nums[i], min_array[i - 1] * nums[i]);
            max_array[i] = Math.max(tmp1, nums[i]);
            tmp1 = Math.min(max_array[i - 1] * nums[i], min_array[i - 1] * nums[i]);
            min_array[i] = Math.min(tmp1, nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i : max_array) {
            if (res < i){
                res = i;
            }
        }
        System.out.println(res);
        return res;
    }

    public int maxProduct2(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        System.out.println(ans);
        return ans;
    }
}
