package start_80;

/**
 * 思路1： 采用动态规划
 *          原问题：总数组能组成的最大面积
 *          子问题：截止到第i个位置能组成的最大面积
 *          递推关系：新来的第i个元素和前面的所有位置计算面积，如果所有的面积都不大于上一个，则沿用上一个，否则进行更新
 *          这种方法在数组长度很大时会超时
 * 思路2： 官方给出的版本：
 *          1. 对于每根柱子，有这样一种关系：分别向左向右遍历，如果下一个元素大于该元素的值，说明该位置是可扩展的
 *              直到左右两边都到达第一个小于该元素的位置为止
 *          2. 对应单调栈的思想，即堆栈内的元素严格单调递增，对于每一个新来的元素，如果该元素小于栈顶元素，则弹出，直到不小于为止，
 *             堆栈内存放的是元素对应的坐标值
 *          3. 分别建立left和right两个数组，存放每根柱子所对应的左边和右边最近的位置（即能够扩展的最大面积）
 *          4. 计算每根柱子对应的扩展面积取最大值
 */

import java.util.*;

public class Histogram_84 {
    public static void main(String[] args) {
        int[] heights = {1,1,2,1,5,4,2,2};
//        Arrays.sort(heights, 0, 2);
//        for (int height : heights) {
//            System.out.println(height);
//        }
        new Histogram_84().largestRectangle2(heights);
    }
    public int largestRectangle2(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        //计算每根柱子左边距离他最近的小于他的元素所在的位置
        for (int i = 0; i < heights.length; i ++){
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            left[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(i);
        }

        //计算每根柱子右边距离他最近的小于他的元素所在的位置
        stack.clear();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i --){
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            right[i] = stack.size() == 0 ? heights.length : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < left.length; i ++){
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] area = new int[heights.length];
        area[0] = heights[0];
        for (int i = 1; i < heights.length; i ++){
            List<Integer> temp = new ArrayList<>();
            temp.add(heights[i]);
            for (int j = 0; j < i; j ++){
                int res = calculate(heights, j, i);
                temp.add(res);
            }
            Collections.sort(temp);
            if (temp.get(temp.size() - 1) > area[i - 1]){
                area[i] = temp.get(temp.size() - 1);
            }
            else {
                area[i] = area[i - 1];
            }
        }
        for (int i : area) {
            System.out.println(i);
        }
        return area[area.length - 1];
    }

    private int calculate(int[] heights, int start, int end){
        int[] temp = new int[end - start + 1];
        for (int i = start,j = 0; i <= end; i ++, j ++){
            temp[j] = heights[i];
        }
        Arrays.sort(temp);
        return temp[0] * (end - start + 1);
    }
}
