package start_90;

/**
 * 动态规划：(卡特兰数)   https://zhuanlan.zhihu.com/p/97619085
 *          1.设n个节点存在的二叉排序树的个数为G(n)，令f(n)为以i为根的二叉排序树的个数
 *          此时有：G(n) = f(1) + f(2) + ... +f(n)
 *          意思是，总的个数可以看为具有不同根结点的树的数量之和
 *          对于每个f(i)，又可以看成是：在它左边的二叉排序树的数量 ✖ 在它右边的二叉排序树的数量
 *          即：f(i) = G(i - 1) * G(n - i)
 *          最终的递推公式：G(n) = G(1 - 1) * G(n - 1) + G(2 - 1) * G(n - 2) + ... + G(n - 1) * G(n - n)
 */



public class BinarySearchTree2_96 {
    public static void main(String[] args) {
        new BinarySearchTree2_96().numTrees(5);
    }
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        if (n == 0){
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++){
            for (int j = 1; j <= i; j ++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
