package one_six_zero_plus;

/**
 * 时间复杂度为O（logn）的情况优先考虑二分法
 * 不断寻找新的中间元素，并定义往高的方向为要走的方向，最终一定会走得到峰值点
 */

public class find_peak_element_162 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        find_peak_element_162 peakElement162 = new find_peak_element_162();
        int res = peakElement162.findPeakElement(nums);
        System.out.println(res);
    }
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while (end - start > 1){
            if (mid == end){
                return nums[end];
            }
            if (mid == start){
                return nums[start];
            }
            if (nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }
            else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }

        if (mid == 0){
            return nums[mid] > nums[mid + 1] ? mid : mid + 1;
        }
        else if (mid == nums.length - 1){
            return nums[mid] > nums[mid - 1] ? mid : mid - 1;
        }
        else {
            if (Math.max(nums[mid], Math.max(nums[mid - 1], nums[mid + 1])) == nums[mid]){
                return mid;
            }
            else if (Math.max(nums[mid], Math.max(nums[mid - 1], nums[mid + 1])) == nums[mid + 1]){
                return mid + 1;
            }
            else {
                return mid - 1;
            }
        }
    }
}
