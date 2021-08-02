//在数组中寻找三个数之和为0的元素，跟容器放水的题目类似，善用Arrays.sort和collections.sort排序
//Arrays.asList可同时向list添加多个元素，hashset可用来判断是否有重复

import java.util.*;


public class find_triplets {
    public static void main(String[] args) {
        Solution_ft gt = new Solution_ft();
        int[] er = {-1,0,1,2,-1,-4};
        gt.threeSum(er);
    }
}


class Solution_ft {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        Set<List> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k --;
                }
                else if(sum < 0) {
                    j ++;
                }
                else {
                    List<Integer> ll = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(ll);
                    if (set.add(ll)) {
                        result.add(ll);
                    }
                    j ++;
                }
            }
        }
        System.out.println(result);
        return result;
    }
}