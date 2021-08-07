**排列组合**

```java
import java.util.Stack;

public class Main {
  
  public static Stack<Integer> stack = new Stack<Integer>();
  public static void main(String[] args) {
     int shu[] = {1, 2, 3, 4};
     f(shu, 4 , 0);
   }
   /**
    *
    * @param shu  待选择的数组
    * @param targ 要选择多少个次
    * @param cur  当前选择的是第几次
    */
   private static void f(int[] shu, int targ, int cur) {
     // TODO Auto-generated method stub
     if (cur == targ) {
       System.out.println(stack);
       return ;
     }
    
     for ( int i= 0 ;i < shu.length; i ++) {
       stack.add(shu[i]);
       f(shu, targ, cur + 1 );
       stack.pop();
      
     }
   }
    
    //or(排列无重复元素)
    for(int i = 0;i < shu.length; i ++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, cur + 1);
                stack.pop();
            }
```

**回溯模板（深度优先搜索）**

```java
int check(参数)
{
    if (满足条件)
    {
        return 1;
    }
    return 0;
}

void dfs(int step){
    判断边界
    {
        相应操作
    }
    尝试每一种可能
    {
        满足check条件
        标记
        继续下一步dfs(step + 1)
        恢复初始状态（回溯的时候要用到）
    }
}
```

