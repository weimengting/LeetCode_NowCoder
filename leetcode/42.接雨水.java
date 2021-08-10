package start_30;

//没有解出来，浪费了两个小时。。
//答案是第二个带注解的
//对于每根柱子，左右两边都比他高才有可能存的住水

public class GetRain_42 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution_422 solution_422 = new Solution_422();
        solution_422.trap(nums);
    }
}

class Solution_42 {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; ){
            int[] tt = area(height, i);
            res += tt[1];
            i = tt[0];
        }
        System.out.println(res);
        return res;
    }

    private int[] area(int[] height, int ind){
        int[] tmp = new int[2];
        int end = ind + 1;
        while (end < height.length && height[end] < height[ind]){
            end ++;
        }
        if (end == height.length){
            tmp[0] = ind + 1;
            return tmp;
        }
        int ara = Math.min(height[ind], height[end]) * (end - ind - 1);
        for (int i = ind + 1; i < end; i ++){
            ara -= height[i];
        }
        tmp[0] = end;
        tmp[1] = ara;
        return tmp;
    }
}


class Solution_422 {
    public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}