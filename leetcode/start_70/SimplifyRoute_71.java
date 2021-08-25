package start_70;

//理解题意：什么是合法路径

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyRoute_71 {
    public static void main(String[] args) {
        String res = new SimplifyRoute_71().simplifyPath("/c/v/./f/../");
        System.out.println(res);
    }

    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        // 判空
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
