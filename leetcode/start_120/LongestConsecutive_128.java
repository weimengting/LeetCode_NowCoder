package start_120;

/**
 * 先用set进行去重
 * 如果x, x + 1, x + 2, ... , x + n是一个能够存在的连续序列（x表示当前遍历到的元素值）
 * 此时如果x - 1 存在于数组中，则新形成的连续数组的长度一定会比上一个要长
 */

import java.util.*;

public class LongestConsecutive_128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        new LongestConsecutive_128().longestConsecutive(nums);
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)){
                int count = 0;
                while (set.contains(num + 1)){
                    count ++;
                    num ++;
                }
                res = Math.max(res, count);
            }
        }
        return res + 1;
    }
}
