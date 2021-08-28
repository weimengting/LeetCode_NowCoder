package start_80;

/**
 * 动态规划：
 *         每次放入一个新的元素时，原来的列表中的每个集合都要在加上新来的元素
 *         并将形成的新列表添加到原来的列表当中
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSet2_90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        new SubSet2_90().subsetsWithDup2(nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());


        for (int i = 1; i <= nums.length; i ++){
            List<List<Integer>> temp = new ArrayList<>();
            temp = part(res, nums, i);
            res.addAll(temp);
            System.out.println(res);
        }
        List<List<Integer>> ff = new ArrayList<>();
        return ff;
    }

    private List<List<Integer>> part(Set<List<Integer>> temp, int[] nums, int i){
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> re : temp) {
            List<Integer> tr = new ArrayList<>(re);
            tr.add(nums[i - 1]);
            res.add(tr);
        }
        return res;
    }


    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i ++){
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> re : res) {
                List<Integer> tr = new ArrayList<>(re);
                tr.add(nums[i - 1]);
                temp.add(tr);
            }
            res.addAll(temp);
            System.out.println(res);
        }
        List<List<Integer>> ff = new ArrayList<>(res);
        return ff;
    }
}
