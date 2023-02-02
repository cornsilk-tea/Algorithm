import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];
        for(int computerNumber = 0; computerNumber < n; computerNumber++){
            if(v[computerNumber] == false){
                answer++;
                dfs(computerNumber, computers, v);
            }
        }
        return answer;
    }
    public void dfs(int currentComputerNumber, int[][] computers, boolean[] v){
        v[currentComputerNumber] = true;
        for(int nextComputerNumber = 0; nextComputerNumber < computers.length; nextComputerNumber++){
            if(computers[currentComputerNumber][nextComputerNumber] == 1 && v[nextComputerNumber] == false){
                dfs(nextComputerNumber, computers, v);
            }
        }
    }
}