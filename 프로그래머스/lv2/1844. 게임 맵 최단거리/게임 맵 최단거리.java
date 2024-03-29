import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        // bfs 문제
        int[][] v = new int[maps.length][maps[0].length];
        bfs(v,maps);
        answer = v[maps.length-1][maps[0].length-1];
        if(answer == 0) answer = -1;
        return answer;
    }
    public void bfs(int[][] v, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        v[0][0] = 1;
        int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{-1,0,1,0};
        while(!q.isEmpty()){
            int[] current = q.remove();
            int cr = current[0];
            int cc = current[1];
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length){
                    continue;
                }
                if(v[nr][nc] == 0 && maps[nr][nc] == 1){
                    v[nr][nc] = v[cr][cc]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}