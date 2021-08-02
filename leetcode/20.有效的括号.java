//思路很简单，但涉及的堆栈知识点需要看一下
//自己坐了一下午没解出来，凉凉,push和pop的先进后出原理，背答案吧，题目有点坑，python确实也有比较简洁的做法


import java.util.*;

public class ValidParentheses20 {
    public static void main(String[] args) {
        Solution_boo wt = new Solution_boo();
        boolean result = wt.isValid("([{)]}");
        System.out.println(result);

    }
}


class Solution_boo {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for (char ch : chars) {
            boolean left = ch == '(' || ch == '[' || ch == '{';
            if (left) q.push(ch);

            else if (q.isEmpty() || !match(q.pop(), ch)) return false;

        }
        return q.isEmpty();
    }

    private boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }

}

