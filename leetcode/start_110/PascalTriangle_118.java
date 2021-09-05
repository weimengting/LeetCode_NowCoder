package start_110;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    public static void main(String[] args) {
        new PascalTriangle_118().generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        for (int i = 2; i <= numRows; i ++){
            List<Integer> tt = new ArrayList<>();
            for (int j = 0; j < temp.size(); j ++){
                if (j == 0){
                    tt.add(temp.get(j));
                }
                if (j > 0){
                    tt.add(temp.get(j) + temp.get(j - 1));
                }
                if (j == temp.size() - 1){
                    tt.add(temp.get(j));
                }
            }
            res.add(tt);
            temp = new ArrayList<>(tt);
        }
        System.out.println(res);
        return res;
    }
}
