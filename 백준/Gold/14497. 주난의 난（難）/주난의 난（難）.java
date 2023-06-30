import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] junan;
    static int[] target;
    static char[][] map;
    static int[] deltas = {0,-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        junan = new int[2];
        target = new int[2];
        map = new char[N][M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            if(i < 2){
                junan[i] = Integer.parseInt(st.nextToken()) -1;
            }
            else{
                target[i-2] = Integer.parseInt(st.nextToken()) -1;
            }
        }
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        // bfs로 탐색
        int[][] visited = new int[N][M];
        // 친구가 없는 곳에서는 다음 파동으로 넘기기 위해 deque의 앞에 다음 위치를 넣어준다.
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(junan);
        visited[junan[0]][junan[1]] = 1;
        // 탐색시 현재위치
        int[] curr;
        int r, c, nr, nc, result = 0;
        while(!dq.isEmpty()){
            curr = dq.pollFirst();
            r = curr[0];
            c = curr[1];
            if(Arrays.equals(curr, target)){
                // 찾음
                result = Math.max(visited[r][c]-1, result);
                break;
            }
            for(int d = 0; d < 4; d++){
                nr = r + deltas[d];
                nc = c + deltas[d+1];
                if(isArrOut(nr, nc) || visited[nr][nc] > 0)
                    continue;
                if(map[nr][nc] == '0'){
                    visited[nr][nc] = visited[r][c];
                    dq.addFirst(new int[]{nr, nc});
                }
                else{
                    visited[nr][nc] = visited[r][c] + 1;
                    dq.addLast(new int[]{nr, nc});
                }
            }
        }
        System.out.println(result);
    }
    static boolean isArrOut(int r, int c){
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}