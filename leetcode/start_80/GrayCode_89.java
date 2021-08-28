package start_80;

/**
 * 动态规划：
 *          连续的n之间存在着这样一种关系：对于上一个n中得到的所有二进制的结果，在每个结果后面先依次补0
 *          再遍历一次，依次补1，由于题目要求相邻的两个二进制结果之间只能有1位的差距
 *          因此，在补1的时候，要将顺序倒过来遍历
 *          最后用Integer.parseInt将二进制的字符串转化成10进制
 *          不如直接递归的效率高
 */

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public static void main(String[] args) {
        new GrayCode_89().grayCode(2);
    }
    public List<Integer> grayCode(int n) {
        List<StringBuilder> res = new ArrayList<>();
        if (n == 0){
            List<Integer> rr = new ArrayList<>();
            rr.add(0);
            return rr;
        }
        if (n == 1){
            List<Integer> rr = new ArrayList<>();
            rr.add(0);rr.add(1);
            return rr;
        }
        StringBuilder temp1 = new StringBuilder();
        temp1.append(0);
        res.add(temp1);
        StringBuilder temp2 = new StringBuilder();
        temp2.append(1);
        res.add(temp2);

        for (int i = 2; i <= n; i ++){
            List<StringBuilder> trans = new ArrayList<>();
            for (int j = 0; j < res.size(); j ++){
                String temp = res.get(j).toString();
                temp += "0";
                trans.add(new StringBuilder(temp));
            }
            for (int j = res.size() - 1; j >= 0; j --){
                String temp = res.get(j).toString();
                temp += "1";
                trans.add(new StringBuilder(temp));
            }
            res.clear();
            res = trans;
            //System.out.println(res);
        }
        List<Integer> lm = new ArrayList<>();
        for (StringBuilder re : res) {
            int temp = Integer.parseInt(re.toString(), 2);
            lm.add(temp);
        }
        //System.out.println(lm);
        return lm;
    }
}
