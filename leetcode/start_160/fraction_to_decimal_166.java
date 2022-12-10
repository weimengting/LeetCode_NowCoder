package one_six_zero_plus;

import java.math.BigDecimal;
import java.sql.Struct;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

/**
 * 百度了一个可以优化的算法：(事实证明这种思路行不通)
 * 纯无限循环小数 化为分数时，分子是循环节， 分母由同位数的 9 组成。
 * 若分子分母未约分， 分子是循环节；
 * 若约为最简分数， 分子就是循环节的因数之一。
 * 例如
 * 0.232323... = 23/99
 * 0.273273273... = 273/999 = 91/333
 */

public class fraction_to_decimal_166 {
    public static void main(String[] args) {
        fraction_to_decimal_166 toDecimal166 = new fraction_to_decimal_166();
        String res = toDecimal166.fractionToDecimal(1, 214748364);
        System.out.println(res);
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){
            return "0";
        }

        return "s";
    }
}
