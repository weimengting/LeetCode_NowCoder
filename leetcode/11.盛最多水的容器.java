//贪心算法的经典例题，自己做的超时,从两边向中间走，保证每次移动时都可能比上次更优


public class water {
    public static void main(String[] args) {
        Solutionww se = new Solutionww();
        int[] test = {1,8,6,2,5,4,8,3,7};
        int ff = se.maxArea(test);
        System.out.println(ff);
    }
}


class Solutionww {
    public int maxArea(int[] height) {
        int mm = 0;
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                mm = (j - i) * Math.min(height[i], height[j]);
                area = Math.max(area, mm);
            }
        }
        return area;
    }
}

class stand {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i ++;
            }
            else{
                j --;
            }
        }
        return res;
    }
}
