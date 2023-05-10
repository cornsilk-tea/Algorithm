import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int h = 1; h < citations[citations.length-1]; h++){
            // 계산
            int over = 0;
            int less = 0;
            for(int i : citations){
                if(i >= h){
                    over+=1;
                } else {
                    less+=1;
                }
            }
            if(over >= h && less <= h){
                answer = Math.max(answer, h);
            }
        }
        return answer;
    }
}