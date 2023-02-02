import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int tc = 0; tc < answer.length; tc++){
            // 시작
            int[] tempTable = Arrays.copyOfRange(array, commands[tc][0]-1, commands[tc][1]);
            Arrays.sort(tempTable);
            System.out.println(Arrays.toString(tempTable));
            answer[tc] = tempTable[commands[tc][2]-1];
        }
        
        return answer;
    }
}