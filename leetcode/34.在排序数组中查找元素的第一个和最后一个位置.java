package start_30;

//依旧使用二分法原理，另加一个中间向两侧查找

public class First_and_last_34 {
}

class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (search(nums, target)[0] == -1){
            res[0] = -1; res[1] = -1;
            return res;
        }

        else{
            int mid = search(nums, target)[1];
            res[0] = mid; res[1] = mid;
            int left = mid - 1;
            int right = mid + 1;
            boolean[] loop = {true, true};
            while (loop[0] || loop[1]){
                if (left >= 0) {
                    if (nums[left] == target) {
                        res[0] = left;
                        left --;
                    } else {
                        loop[0] = false;
                    }
                }
                else{
                    loop[0] = false;
                }
                if (right < nums.length) {
                    if (nums[right] == target) {
                        res[1] = right;
                        right ++;
                    } else {
                        loop[1] = false;
                    }
                }
                else {
                    loop[1] = false;
                }
            }
        }
        return res;
    }

    private int[] search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        int[] inds = new int[2];
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                inds[1] = mid;
                return inds;
            }
            if (nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums.length == 0){
            inds[0] = -1;
            return inds;
        }
        if (nums[start] == target) {
            inds[1] = start;
            return inds;
        }
        if (nums[end] == target) {
            inds[1] = end;
            return inds;
        }
        inds[0] = -1;
        return inds;
    }
}
