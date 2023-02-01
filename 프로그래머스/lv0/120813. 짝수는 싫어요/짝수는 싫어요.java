import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public Object[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i =1; i <= n; i++){
            if(i%2 != 0) list.add(i);
        }
        return list.toArray();
    }
}