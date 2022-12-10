package one_five_zero_plus;

// 二分法查找转折点
/*
    有一个特例需要考虑，即数组本来就是正序排列的，这样可以用第一个元素不小于最后一个元素的方式来判定
 */

public class find_min_153 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        find_min_153 findMin153 = new find_min_153();
        int res = findMin153.findMin(nums);
        System.out.println(res);
    }
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1 || nums[0] < nums[length - 1]){
            return nums[0];
        }

        int mid = 0;
        int start = 0, end = length - 1;
        while (end - start > 1){
            mid = start + (end - start) / 2;
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
