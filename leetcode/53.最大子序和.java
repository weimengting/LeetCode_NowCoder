package start_50;

import java.util.Arrays;

public class MaxSub_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        new MaxSub_53().maxSubArray(nums);
    }
    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i ++){
            res[i] = record(i, nums);
        }
        for (int re : res) {
            System.out.println(re);
        }
        Arrays.sort(res);
        return res[res.length - 1];
    }

    private int record(int start, int[] nums){
        int max = nums[start];
        int cur = nums[start];
        for (int i = start + 1; i < nums.length; i ++){
            cur = cur + nums[i];
            max = Math.max(cur, max);
        }
        return max;
    }
}
