package start_60;

//二分法求解，不然会超时，注意while的终止条件

public class XSqrt_69 {
    public static void main(String[] args) {
        int res = new XSqrt_69().mySqrt(9);
        System.out.println(res);
    }
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int left = 1;
        int right = x;
        while ((right - left) > 1){
            int mid = left + ((right - left) / 2);
            if ((long) mid * mid < x){
                left = mid;
            }
            else if ((long) mid * mid > x){
                right = mid;
            }
            else {
                return mid;
            }
        }
        return left;
    }
}
