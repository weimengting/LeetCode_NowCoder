package start_30;

//二分法

public class Search_and_insert_35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 3;
        Solution_35 solution_35 = new Solution_35();
        int res = solution_35.searchInsert(nums, target);
        System.out.println(res);
    }
}


class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[start] >= target){
            return start;
        }
        else if (target <= nums[end]){
            return start + 1;
        }
        else {
            return end + 1;
        }
    }
}
