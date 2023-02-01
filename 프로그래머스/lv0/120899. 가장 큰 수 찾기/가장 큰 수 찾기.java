import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        List<String> list = new ArrayList();
        for(int i : array){
            list.add(i+"");
        }
        Arrays.sort(array);
        answer[0] = array[array.length-1];
        answer[1] = list.indexOf(answer[0]+"");
        return answer;
    }
}