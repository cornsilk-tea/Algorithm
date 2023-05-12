import java.util.*;

class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            // 배열정렬
            Arrays.sort(people);
            int leftIdx = 0;
            int rightIdx = people.length-1;
            while(rightIdx >= leftIdx){
                if(people[leftIdx] + people[rightIdx] <= limit){
                    leftIdx++;
                    rightIdx--;
                }
                else{
                    rightIdx--;
                }
                answer++;
            }
            return answer;
        }
    }