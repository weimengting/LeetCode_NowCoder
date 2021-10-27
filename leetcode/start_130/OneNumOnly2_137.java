package start_130;

//这种题单步去想反而容易陷进去

public class OneNumOnly2_137 {
    public static void main(String[] args) {
        int[] nums = {2,1,2,1,2,1,99};
        new OneNumOnly2_137().singleNumber(nums);
    }
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            two = (two | (one & num));
            one = (one ^ num);
            three = (one & two);
            //一旦three为一，就将two和one全部置零
            two = (two & (~three));
            one = (one & (~three));
        }
        return one;
    }
}
