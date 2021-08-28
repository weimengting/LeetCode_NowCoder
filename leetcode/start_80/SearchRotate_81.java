package start_80;
/**
 * 相较于原来的无重复元素的二分查找方法，该题的难点在于处理 a[l]=a[mid]=a[r]的情况，
 * 此时无法判断是前面的区间还是后面的区间全部为重复元素，对于这种情况，只能将当前的左元素加一，右元素减一，然后继续二分查找
 * 这种算法对于长度比较短的数组的处理效率其实是不如直接暴力遍历的
 * 因为大量的if，else会消耗时间
 */


public class SearchRotate_81 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        boolean res = new SearchRotate_81().search(nums, 1);
        System.out.println(res);
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            }
            else if (nums[l] <= nums[mid]) {  //左段区间为升序数组
                if (nums[l] <= target && target < nums[mid]) { //判断目标元素在左边还是右边
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            else {           //右段区间为升序数组
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
