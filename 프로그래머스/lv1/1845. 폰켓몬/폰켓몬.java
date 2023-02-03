import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.size() == nums.length/2) break;
            set.add(i);
        }
        answer = set.size();
        return answer;
    }
}