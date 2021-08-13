package start_30;

//直接遍历会超时，看答案解析

public class Pow_50 {
    public static void main(String[] args) {
        double ee = new Pow_50().myPow(2, 10);
        System.out.println(ee);
    }
    public double myPow(double x, int n) {
        long tt = Math.abs(n);
        double res = check(x, tt);
        return n < 0 ? (1 / res) : res;
    }

    public double check(double x, long n){
        if (n == 0){
            return 1;
        }
        double y = check(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
