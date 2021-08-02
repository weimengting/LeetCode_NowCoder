//将整数翻转并输出，注意不能有数据溢出
//测试能够通过，注意多位数分解技巧


import java.util.ArrayList;
import java.util.List;

public class reverse {
    public static void main(String[] args) {
        Solution4 df = new Solution4();
        int re = df.reverse(1563847412);
        System.out.println(re);
    }
}


class Solution4 {
    public int reverse(int x) {
        List<Integer> yu = new ArrayList<>();
        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }
        int y = x;
        while (y != 0) {
            x = y % 10;
            yu.add(x);
            y = y / 10;
        }
        for (int i = yu.size() - 1; i >= 0; i --) {
            //System.out.println(y);
            if (y > Integer.MIN_VALUE && y < Integer.MAX_VALUE) {
                y += Math.pow(10, i) * yu.get(yu.size() - i - 1);
            }
            else {
                return 0;
            }
        }
        return y;
    }
}


class Solution44 {
    public int reverse(int x) {
        long res = 0;
        // 考虑负数情况，所以这里条件为: x != 0
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res < Integer.MIN_VALUE || res > Integer.MAX_VALUE ? 0 : (int) res;
    }
}
