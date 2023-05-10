import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        Character[] arr = new Character[s.length()];
        int idx = 0;
        for(char c : s.toCharArray()){
            arr[idx++] = c;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(char c : arr){
            answer+= c;
        }
        return answer;
    }
}