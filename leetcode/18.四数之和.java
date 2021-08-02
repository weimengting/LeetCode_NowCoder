//对应第18题，跟那种几个数之和的如出一辙，双指针，水桶，数组排序，用set避免重复

import java.util.*;

public class sum_4 {
    public static void main(String[] args) {
        Solution_list ed = new Solution_list();
        int[] nums = {1,0,-1,0,-2,2};
        ed.fourSum(nums, 0);
    }
}

class Solution_list {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        Set<List> set = new HashSet<>();
        Arrays.sort(nums);
        if (nums.length < 4) {return list;}
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                for (int k = j + 1, m = nums.length - 1; k < m;) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum > target) {m --;}
                    else if (sum < target) {k ++;}
                    else {
                        List<Integer> ll = Arrays.asList(nums[i], nums[j], nums[k], nums[m]);
                        Collections.sort(ll);
                        if (set.add(ll)) {list.add(ll);}
                        k ++;
                    }
                }
            }
        }
        System.out.println(list);
        return list;
    }
}