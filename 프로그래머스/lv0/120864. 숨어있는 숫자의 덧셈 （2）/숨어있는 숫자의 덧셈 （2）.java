import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] ms = my_string.split("[a-zA-Z]");
        System.out.println(Arrays.toString(ms));
        for(String s : ms){
            if(!s.equals(""))
            answer+=Integer.parseInt(s);
        }
        return answer;
    }
}