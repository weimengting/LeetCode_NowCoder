//注意字符串的越界问题，巧妙利用equals和substring
//2020年华为校招的笔试题


public class common_pre {
    public static void main(String[] args) {
        Solution_po ld = new Solution_po();
        String[] ss = {"rag","r","rar"};
        String pre = ld.longestCommonPrefix(ss);
        System.out.println(pre);
    }
}


class Solution_po {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int x = 0, y = 1;
        String prefix = "";
        while (strs[0].length() >= y) {
            prefix = strs[0].substring(x, y);
            for (int i = 1; i < n;) {
                if (strs[i].length() >= y) {
                    if (strs[i].substring(x, y).equals(prefix)) {
                        i ++;
                    }
                    else {
                        return prefix.substring(x, y - 1);
                    }
                }
                else {
                    return prefix.substring(x, y - 1);
                }
            }
            y ++;
        }
        System.out.println(prefix);
        return  prefix;
    }
}