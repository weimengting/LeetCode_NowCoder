package start_130;

//首先进入脑海的就是链表的插入与删除
//答案总是叫人大写的服气
/**
 * 使用位运算。对于这道题，可使用异或运算⊕。异或运算有以下三个性质。
 * 任何数和0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
 * 任何数和其自身做异或运算，结果是 00，即 a⊕a=0。
 * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OneNumOnly_136 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        new OneNumOnly_136().singleNumber(nums);
        System.out.println(18 ^ 10);   //转化为二进制然后做异或运算，再换成十进制
    }
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)){
                int ind = list.indexOf(num);
                list.remove(ind);
            }
            else {
                list.add(num);
            }

        }
        return list.get(0);
    }
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;  //注意异或运算符
        }
        return single;
    }
}
