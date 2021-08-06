package start_30;

//要求控制时间复杂度，用二分法查找

public class search_whilr_33 {
}



class Solution_33{
    public int search(int[] nums, int target){

        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}

class Solution_333 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}