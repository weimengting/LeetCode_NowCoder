package one_six_zero_plus;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// 基数排序法的时间复杂度为 O（n），参考https://baike.baidu.com/item/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F

public class maxmum_gap_164 {
    public static void main(String[] args) {
        int[] nums = {130,600999,900,0};
        maxmum_gap_164 gap164 = new maxmum_gap_164();
        gap164.maximumGap(nums);
    }
    public int maximumGap(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<Integer> divisor = new ArrayList<>();
        int count = 0, div = 1;
        boolean loop = true;
        while (loop){
            for (int i = 0; i < nums.length; i ++){
                // tmp用来暂时存放当前的除数
                int cur_digit = 0;
                if (count == 0){
                    cur_digit = nums[i] % 10;
                }
                else {
                    cur_digit = nums[i] / div;
                }
                if (map.containsKey(cur_digit)){
                    List<Integer> temp = map.get(cur_digit);
                    temp.add(nums[i]);
                    map.put(cur_digit, temp);
                }
                else {
                    List<Integer> putin = new ArrayList<>();
                    putin.add(nums[i]);
                    map.put(cur_digit, putin);
                }

                if (count !=0 && cur_digit == 0){
                    divisor.add(1);
                }
            }
            int m = 0;
            for (List<Integer> value : map.values()) {
                if (value.size() != 0){
                    for (Integer integer : value) {
                        nums[m] = integer;
                        m ++;
                    }
                }
            }
            if (divisor.size() == nums.length){
                loop = false;
            }
            map.clear();
            divisor.clear();
            count ++;
            div *= 10;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i ++){
            System.out.println(nums[i]);
            if (i != nums.length - 1){
                if (nums[i + 1] - nums[i] > max){
                    max = nums[i + 1] - nums[i];
                }
            }
        }
        return max;
    }
}
