public class Implement_strStr_28 {
    public static void main(String[] args) {
        Solution_28 gh = new Solution_28();
        gh.strStr("aaaaa", "a");
    }
}



class Solution_28 {
    public int strStr(String haystack, String needle) {
        int index = 0;
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        if (haystack.contains(needle)) {
            index = haystack.indexOf(needle);
            return index;
        }
        else return -1;

    }
}
