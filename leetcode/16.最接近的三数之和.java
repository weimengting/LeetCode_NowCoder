//与水桶问题，三数之和问题一样


import java.util.*;

public class closet {
    public static void main(String[] args) {
        int[] aa = {1, 1, -1, -1, 3};
        Solution67 fr = new Solution67();
        int res = fr.threeSumClosest(aa, -1);
        System.out.println(res);
    }
}


class Solution67 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int save = 0;
        if (nums.length < 3) {return 0;}
        int clo = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp > target) {k --;}
                else if (temp < target) {j ++;}
                else {return temp;}
                int ft = Math.abs(temp - target);
                if (clo > ft) {
                    clo = ft;
                    save = temp;
                }
            }
        }
        return save;
    }
}