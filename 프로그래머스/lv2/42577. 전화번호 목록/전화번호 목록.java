import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book){
            set.add(phone);
        }
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(set.contains(phone_book[i].substring(0,j))) 
                    return false;
            }
        }
        return answer;
    }
}