package start_30;

//冒泡法排序，Arrays.sort可以规定索引位置，排列某一区域的数组，不要重复造轮子


import java.util.Arrays;

public class NextArrangement_31 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
        Solution_31 er = new Solution_31();
        nums = er.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

}


class Solution_31 {
    public int[] nextPermutation(int[] nums) {
        int len = nums.length;
        int temp = 0;
        for (int i = len - 1; i > 0; i --){
            int left = nums[i - 1];
            int right = nums[i];
            if (left < right){
                temp = i - 1;
                break;
            }
        }

        Arrays.sort(nums, temp + 1, len);

        for (int i = temp + 1; i < len; i ++){
            if (nums[i] > nums[temp]){
                int buf = nums[i];
                nums[i] = nums[temp];
                nums[temp] = buf;
                return nums;
            }
        }

        Arrays.sort(nums);
        return nums;
    }
}