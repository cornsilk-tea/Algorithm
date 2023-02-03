import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();
        for(int n : arr){
            if(stack.empty()){
                stack.push(n);
            }
            else{
                if(stack.peek() != n){
                    stack.push(n);
                }
            }
        }
        answer = new int[stack.size()];
        for(int i = answer.length-1; i >= 0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}