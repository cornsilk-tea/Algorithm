import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp.charAt(j)+"");
            }
        }

        bfs(new int[]{0,0});
//        for (int[] a : check) {
//            for (int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }
        System.out.println(check[N-1][M-1]);
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    private static void bfs(int[] ints) {
        Queue<int[]> q = new LinkedList<>();
        q.add(ints);
        check[ints[0]][ints[1]] = 1;
        while(!q.isEmpty()){
            int[] current = q.remove();
            int cr = current[0];
            int cc = current[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M){
                    continue;
                }
                if(check[nr][nc] == 0 && map[nr][nc] == 1){
                    check[nr][nc] = check[cr][cc] +1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}