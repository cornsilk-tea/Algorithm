import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!v[i]){
                answer++;
                dfs(i,computers,v);
            }
        }
        return answer;
    }
    public void dfs(int com, int[][] computers, boolean[] v){
        v[com] = true;
        for(int ncom = 0; ncom < v.length; ncom++){
            if(!v[ncom] && computers[com][ncom] == 1){
                dfs(ncom, computers,v);
            }
        }
    }
}