package start_80;

/**
 * 最直接的方法是将s2放到s1后面，排序
 * 采用双指针虽然理论上可以节省时间复杂度，但是if，else的判断实际处理时在面对不太长的数组时效率并不比直接排序的效率高
 */

public class MergeTwoArrays_88 {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        new MergeTwoArrays_88().merge(nums1, m, nums2, n);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0){
            return;
        }
        if (n == 0){
            return;
        }
        if (m == 0){
            for (int i = 0; i < nums2.length; i ++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int[] temp = new int[m + n];
        //分别表示两个数组当前指向的位置
        int cur_num1 = 0;
        int cur_num2 = 0;
        for (int i = 0; i < temp.length; i ++){
            if ((cur_num1 < m && cur_num2 == n) || (cur_num1 < m && nums1[cur_num1] < nums2[cur_num2])){
                temp[i] = nums1[cur_num1];
                cur_num1 ++;
            }
            else if ((cur_num2 < n && cur_num1 == m) || (cur_num2 < n &&nums1[cur_num1] > nums2[cur_num2])){
                temp[i] = nums2[cur_num2];
                cur_num2 ++;
            }
            else {
                temp[i] = nums1[cur_num1];
                temp[i + 1] = nums2[cur_num2];
                cur_num1 ++;
                cur_num2 ++;
                i ++;
            }
        }
        for (int i = 0; i < temp.length; i ++){
            nums1[i] = temp[i];
        }
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
