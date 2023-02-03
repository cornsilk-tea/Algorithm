import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            stringNumbers[i] = numbers[i]+"";
        }
        Arrays.sort(stringNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for(String s : stringNumbers){
            answer+=s;
        }
        return answer.charAt(0)=='0'?"0":answer;
    }
}