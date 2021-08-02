//既然末尾不重要，将需要删除的数据对应的位置存成最大值

import java.util.Arrays;

public class Remove_Element_27 {
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
                count ++;
            }
        }
        Arrays.sort(nums);
        return nums.length - count;
    }
}
