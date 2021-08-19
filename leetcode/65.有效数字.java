package start_60;

//如果使用状态机if，else进行判断很容易绕进入
//直接用try，catch语句判断是否能够转化成数字，不能的话对异常进行忽略

public class ValidNumber_65 {
    public static void main(String[] args) {
        boolean res = new ValidNumber_65().isFloat("Infinity");
        System.out.println(res);
    }

    private boolean isFloat(String s){
        int sign = 0;
        if (s.equals("Infinity") || s.equals("-Infinity") || s.equals("+Infinity")){
            return false;
        }
        if (Character.isLetter(s.charAt(s.length() - 1))){
            return false;
        }
        try{
            float m = Float.parseFloat(s);
            sign = 1;
        }catch (Exception ignored){

        }
        return sign == 1;
    }
}
