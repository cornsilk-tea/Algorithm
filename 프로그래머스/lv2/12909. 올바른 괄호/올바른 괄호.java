import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == ')'){
                if(stack.empty()) return false;
                if(stack.peek() == '('){
                    stack.pop();
                }
            }
            else{
                stack.push(c);
            }
        }
        
        return stack.size() == 0? true:false;
    }
}