import java.util.*;
class Solution {
    public Object[] solution(int n, int[] numlist) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        for(int i : numlist){
            if(i%n==0) list.add(i);
        }
        return list.toArray();
    }
}