//题目描述比较复杂，对应leetcode第8题
//无脑if else
//不要动不动就用list，字符和数字之间有更快捷的转换方式，答案对于溢出判断处理的很巧妙

import java.util.List;
import java.util.ArrayList;


public class find_num {
    public static void main(String[] args) {
        Solution55 dp = new Solution55();
        int re = dp.myAtoi("-91283472332");
        //dp.test("0123456789");
        System.out.println(re);
    }
}


class Solution5 {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int i = 0, sign;

        while (s.charAt(i) == ' ') {
            if (++i >= s.length()) {
                return 0;
            }
        }
        if (s.charAt(i) == '+' || Character.isDigit(s.charAt(i))) {
            sign = 1;
            if (s.charAt(i) == '+') {
                i++;
            }
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else {
            return 0;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i) - 48;
            if ((sign == 1) && (res > (Integer.MAX_VALUE - sign * num) / 10)) {
                return Integer.MAX_VALUE;
            } else if ((sign == -1) && (res < (Integer.MIN_VALUE - sign * num) / 10)) {
                return Integer.MIN_VALUE;
            }
            res = 10 * res + sign * num;
            i++;
        }
        return res;
    }
}


class Solution55 {
    public int myAtoi(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        while (s.charAt(i) == ' ') {
            // 仅包含空格
            if (++i == n) return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;
        int res = 0;
        int flag = Integer.MAX_VALUE / 10;
        //开头只能有一个正负号，否则直接退出循环
        for (; i < n; ++i) {
            // 非数字，跳出循环体
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            // 溢出判断
            if (res > flag || (res == flag && s.charAt(i) > '7')) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res * sign;
    }
}