

```java
class Solution {
    public int[] twoSum(int[] nums, int target){
        int len = nums.length;
        int[] inds = {0, 0};
        for (int i = 0; i < len; i ++) {
            int a = nums[i];
            for (int j = i + 1; j < len; j ++) {
                int b = nums[j];
                if (a + b == target) {
                    inds[0] = i;
                    inds[1] = j;
                    break;
                }
            }
        }
        return inds;
    }
}
```

