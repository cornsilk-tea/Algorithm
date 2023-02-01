import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String is1 : s1){
            for(String is2 : s2){
                if(is1.equals(is2)) answer++;
            }
        }
        return answer;
    }
}