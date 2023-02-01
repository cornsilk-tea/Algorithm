import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int num : numbers){
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0)*list.get(1);
        return answer;
    }
}