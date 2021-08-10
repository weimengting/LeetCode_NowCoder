package start_30;

//题目要求时间复杂度为o（n），并且不允许使用额外的空间
//排序的方法不能用，复杂度为o（NlogN），哈希表也不能用，因为开辟了额外的空间
//换言之：只能在原数组上修改


//遍历：小于等于0 和 大于等于n+1 的数字一律改为 n+1 不改变最后结果 且此时所有元素在1～n+1之间
//遍历：遇到 1<|num|<n 之间的数字 便令第|num|个数字变成负的 (如果之前是正的 变成负的 否则不变)
//再次遍历：如果第i个数字是正的 则说明之前没有出现过i 如果所有数字是负的 则说明1～n都出现了 返回n+1
//第二次遍历很妙。。


import java.util.Arrays;

public class LostInteger_41 {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        Solution_41 solution_41 = new Solution_41();
        solution_41.firstMissingPositive(nums);
    }
}

class Solution_41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] <= 0){
                continue;
            }
            else if (i == 0 || nums[i] != nums[i - 1]){
                start ++;
            }
            if (start != nums[i]){
                System.out.println(start);
                return start;
            }
        }
        System.out.println(start + 1);
        return start + 1;
    }
}


class Solution_41_st {
    public int firstMissingPositive(int[] nums) {
        int lens = nums.length;
        int tmp;
        for (int i = 0; i < lens; i++) {//先把负数全变为正数N+1,不影响后面标记
            if (nums[i] <= 0)
                nums[i] = lens + 1;
        }
        for (int i = 0; i < lens; i++) {//对每个不大于N的正数，标记其下标，将下标对应那个数标位负数。
            tmp = Math.abs(nums[i]);//注意待考察的数可能已经被标位负数，需要取绝对值
            if (tmp <= lens && nums[tmp - 1] > 0) {//若下标已经被标记（负数），不用重复标记
                nums[tmp - 1] = -(nums[tmp - 1]);
            }
        }
        for (int i = 0; i < lens; i++) {//第一个未被标记的数即为答案（不是负数）
            if (nums[i] > 0)
                return i + 1;//下标从0开始，需要+1
        }
        return lens + 1;
    }
}
