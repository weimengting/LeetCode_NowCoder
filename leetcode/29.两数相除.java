//注意时间限制，不能再每次减一个

public class Divide_Two_Integers_29 {
    public static void main(String[] args) {
        Solution_29 dp = new Solution_29();
        int result = dp.divide(-21, 4);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int c = 2;
        System.out.println(c += 1 << 2);
    }
}


class Solution_29 {
    public int divide(int dividend, int divisor) {
        /**
         * 这里都先转成long，以免后面溢出
         */
        long a = dividend >= 0 ? dividend : -1 * (long) dividend;
        long b = divisor >= 0 ? divisor : -1 * (long) divisor;

        long result = 0;

        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; ++i, c <<= 1) {  //c = c << 1
                a -= c;
                result += (1 << i);
            }
        }
        /**
         * 这里是判断两个数的符号位，如果不一样说明结果为负
         */
        result *= ((dividend ^ divisor) >>> 31) != 0 ? -1 : 1;
        /**
         * 如果溢出则返回整数最大值
         */
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
