package DP;

/**贪心算法
 * 如果能够到达最后一个位置的话，则该位置之前的所有位置也一定能达到
 * 遍历每个位置，更新在该位置上能够到达的最远位置
 */


public class SkipGame2_55 {
    public static void main(String[] args) {
        int[] nums = {2,0,0};
        boolean res = new SkipGame2_55().canJump(nums);
        System.out.println(res);
    }
    public boolean canJump(int[] nums) {
        if (nums.length == 0){
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i ++){
            if (i > max){       //如果当前的索引（位置信息）已经超过了能够达到的最远距离，说明无法达到
                return false;
            }
            int cur = i + nums[i];
            max = Math.max(max, cur);
        }
        //System.out.println(max);
        return true;
    }
}
