package start_70;

public class ColorSort_75 {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        new ColorSort_75().sortColors(nums);
    }
    public void sortColors(int[] nums) {
        StringBuilder zero = new StringBuilder();
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        for (int num : nums) {
            if (num == 0){
                zero.append(num);
            }
            else if (num == 1){
                one.append(num);
            }
            else if (num == 2){
                two.append(num);
            }
        }
        for (int i = 0; i < zero.length(); i ++){
            nums[i] = 0;
        }
        for (int i = zero.length(); i < zero.length() + one.length(); i ++){
            nums[i] = 1;
        }
        for (int i = zero.length() + one.length(); i < zero.length() + one.length() + two.length(); i ++){
            nums[i] = 2;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
