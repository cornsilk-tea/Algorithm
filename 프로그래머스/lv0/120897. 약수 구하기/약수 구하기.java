import java.util.*;
class Solution {
    public Object[] solution(int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n%i == 0) list.add(i);
        }
        System.out.println(list);
        return list.toArray();
    }
}