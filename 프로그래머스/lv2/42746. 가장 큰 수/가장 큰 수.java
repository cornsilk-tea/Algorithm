import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] newNumbers = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            newNumbers[i] = Integer.valueOf(numbers[i]);
        }
        Arrays.sort(newNumbers, (a, b) -> {
            String case1 = a+""+b;
            String case2 = b+""+a;
            return case2.compareTo(case1);
        });
        for(int i : newNumbers){
            answer += i+"";
        }
        // 0체크
        if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer;
    }
}