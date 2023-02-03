import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant){
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }
            else{
                map.put(s, 1);
            }
        }
        for(String s : completion){
            if(map.containsKey(s) && map.get(s) == 1){
                map.remove(s);
            }
            else if(map.containsKey(s) && map.get(s)>= 1){
                map.replace(s, map.get(s)-1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            return entry.getKey();
        }
        return answer;
    }
}