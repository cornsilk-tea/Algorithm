import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        boolean check = true;
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){
                check = true;
                answer += c;
            }
            else{
                if(check){
                    answer += Character.toUpperCase(c);
                }
                else{
                    answer += Character.toLowerCase(c);
                }
                check = !check;
            }
        }
        return answer;
    }
}