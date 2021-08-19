package start_60;

//这是一个斐波那契数列
//如果用动态规划的思想，对于每一个台阶的位置，由于每次只能走1步或者2步，所以他只可能从上一个台阶或者是上上一个台阶过来
//将这两种情况的路数相加即可，因为这两种情况肯定是不一样的

public class ClimbStairs_70 {
    public static void main(String[] args) {
        int res = new ClimbStairs_70().climbStairs(4);
        System.out.println(res);
    }
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] num = new int[n];
        num[0] = 1;
        num[1] = 2;
        for (int i = 3; i <= n; i ++){
            num[i - 1] = num[i - 2] + num[i - 3];
        }
        return num[n - 1];
    }
}
