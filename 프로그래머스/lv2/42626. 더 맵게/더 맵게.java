import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : scoville){
            q.add(i);
        }
        // System.out.println(q);
        while(q.peek() < K){
            if(q.size() <= 1) return -1;
            // System.out.println(q);
            int a = q.poll();
            int b = q.poll();
            int value = a+b*2;
            q.add(value);
            answer++;
        }
        return answer;
    }
}