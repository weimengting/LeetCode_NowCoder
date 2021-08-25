package start_70;

//双指针，每遇到一个新的数时，更新start和end的位置
//当end-start大于2时，将该位置的数置为最大值

import java.util.Arrays;

public class DeleteRepeat_80 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = new DeleteRepeat_80().removeDuplicates(nums);
        System.out.println(res);
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2){
            return nums.length;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i ++){
            if (end < nums.length){
                if (end - start + 1 > 2 && nums[end] == nums[start]){
                    nums[i] = Integer.MAX_VALUE;
                }
                else if (nums[end] != nums[start]){
                    start = end;
                }
            }
            end ++;
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == Integer.MAX_VALUE){
                return i;
            }
        }
        return nums.length;
    }
}
