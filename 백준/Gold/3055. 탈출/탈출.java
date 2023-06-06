import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> gosumQ = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int r = 0; r < R; r++){
            String line = br.readLine();
            for(int c = 0; c < C; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'D'){
                    // 비버의 굴 'D'
                }
                else if(map[r][c] == 'S'){
                    // 고슴도치의 위치 'S'
                    gosumQ.add(new int[]{r,c});
                    visited[r][c] = true;
                }
                else if(map[r][c] == '*'){
                    waterQ.add(new int[]{r,c});
                }
            }
        }
        
        int result = findRoute();
        System.out.println(result != -1 ? result : "KAKTUS");
    }

    private static int findRoute() {
        int time = 0;
        while(!gosumQ.isEmpty()){
            int waterSize = waterQ.size();
            for(int i = 0; i < waterSize; i++){
                int[] curr = waterQ.poll();
                for(int d = 0; d < 4; d++){
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    if(isOutOfRange(nr, nc) || map[nr][nc] == 'D' || map[nr][nc] == 'X' || map[nr][nc] == '*'){
                        continue;
                    }
                    map[nr][nc] = '*';
                    waterQ.add(new int[]{nr, nc});
                }
            }
            
            int gosumSize = gosumQ.size();
            for(int i = 0; i < gosumSize; i++){
                int[] curr = gosumQ.poll();
                for(int d = 0; d < 4; d++){
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    if(isOutOfRange(nr, nc) || visited[nr][nc] || map[nr][nc] == 'X' || map[nr][nc] == '*'){
                        continue;
                    }
                    if(map[nr][nc] == 'D'){
                        return time + 1;
                    }
                    visited[nr][nc] = true;
                    gosumQ.add(new int[]{nr, nc});
                }
            }
            time++;
        }
        return -1;
    }

    private static boolean isOutOfRange(int r, int c){
        return r < 0 || c < 0 || r >= R || c >= C;
    }
}