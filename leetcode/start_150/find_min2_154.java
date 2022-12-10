package one_five_zero_plus;

import java.util.HashSet;
import java.util.Set;

public class find_min2_154 {
    public static void main(String[] args) {
        int[] nums = {10,10,10,0,10};
        find_min2_154 findMin2154 = new find_min2_154();
        int res = findMin2154.findMin(nums);
        System.out.println(res);
    }
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1 || nums[0] < nums[length - 1]){
            return nums[0];
        }
        Set<Integer> set = new HashSet<>();
        int mid = 0;
        int start = 0, end = length - 1;
        while (end - start > 1){
            mid = start + (end - start) / 2;
            if (nums[start] == nums[mid]){
                start ++;
                continue;
            }
            if (nums[end] == nums[mid]){
                end --;
                continue;
            }
            if (nums[start] > nums[mid]){
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (mid == 0){
            return Math.min(nums[mid], nums[mid + 1]);
        }
        else if (mid == length - 1){
            return Math.min(nums[mid], nums[mid - 1]);
        }
        else {
            return Math.min(nums[mid], Math.min(nums[mid - 1], nums[mid + 1]));
        }
    }
}
