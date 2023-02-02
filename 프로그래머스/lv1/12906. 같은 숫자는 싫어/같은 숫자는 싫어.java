import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int n = 1; n < arr.length; n++){
            if(stack.peek() != arr[n]) stack.push(arr[n]);
        }
        System.out.println(stack.size());
        answer = new int[stack.size()];
        int cnt = 0;
        for(int i : stack){
            answer[cnt++] = i;
        }
        return answer;
    }
}