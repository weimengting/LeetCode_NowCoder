package one_six_zero_plus;

public class compare_version_165 {
    public static void main(String[] args) {
        compare_version_165 version165 = new compare_version_165();
        version165.compareVersion("0.0", "1.1");
    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int point1 = 0, point2 = 0;
        while (point1 < v1.length && point2 < v2.length){
            int cur_digit1 = Integer.parseInt(v1[point1]);
            int cur_digit2 = Integer.parseInt(v2[point2]);
            if (cur_digit1 < cur_digit2){
                return -1;
            }
            else if (cur_digit1 > cur_digit2){
                return 1;
            }
            point2 ++;
            point1 ++;
        }
        if (v1.length < v2.length){
            for (int i = point2; i < v2.length; i ++){
                if (Integer.parseInt(v2[i]) > 0){
                    return -1;
                }
            }
        }
        if (v1.length > v2.length){
            for (int i = point1; i < v1.length; i ++){
                if (Integer.parseInt(v1[i]) > 0){
                    return 1;
                }
            }
        }
        return 0;
    }
}
