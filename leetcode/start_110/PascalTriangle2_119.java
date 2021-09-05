package start_110;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2_119 {
    public static void main(String[] args) {
        new PascalTriangle2_119().getRow(1);
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int i = 2; i <= rowIndex + 1; i ++){
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
            temp = new ArrayList<>(tt);
        }
        System.out.println(temp);
        return temp;
    }
}
