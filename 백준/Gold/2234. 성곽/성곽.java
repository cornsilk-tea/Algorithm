import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map, visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        /*
            0. 이 성에 있는 방의 개수
            1. 가장 넓은 방의 넓이
            2. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
         */
        result = new int[3];
        map = new int[M][N];
        visited = new int[M][N];
        for(int r = 0; r < M; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int[] a : map){
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println("-----------------------------------");
        // 왼쪽벽이 있으면 1을, 위쪽벽이 있으면 2를,
        // 오른쪽 벽이 있으면 4를, 아래쪽 벽이 있으면 8
        int number = 0;
        List<Integer> areaList = new ArrayList<>();
        for(int r = 0; r < M; r++){
            for(int c = 0; c < N; c++){
                if(visited[r][c] == 0){
                    areaList.add(bfs(r, c, ++number));
                }
            }
        }
        // 0. 이 성에 있는 방의 개수
        result[0] = number;
//        for(int[] a : visited){
//            System.out.println(Arrays.toString(a));
//        }
        // 2. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
        // 이제 이걸 어떻게 구해야할지 생각해보자.
        // 전체를 순차탐색하면서 해당하는 위치에서 어떤 벽을 없앨 수 있는지 확인하고,
        // 벽을 지운 방향에 다른 영역이 존재하면, 그 영역의 값과 현재 영역의 값을 더해 최고값 갱신
        for(int r = 0; r < M; r++){
            for(int c = 0; c < N; c++){
                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= visited.length || nc >= visited[0].length){
                        continue;
                    }
                    if(visited[r][c] != visited[nr][nc]){
                        result[2] = Math.max(result[2], areaList.get(visited[r][c]-1) + areaList.get(visited[nr][nc]-1));
                    }
                }
            }
        }
//        System.out.println("-----------------------------------");
//        System.out.println(Arrays.toString(result));
        for(int i : result){
            System.out.println(i);
        }
    }

    static int[] dr = {-1, 0, 1, 0};  // 북, 동, 남, 서 순서
    static int[] dc = {0, 1, 0, -1};  // 북, 동, 남, 서 순서
    static int[] heading = {2, 4, 8, 1};  // 북, 동, 남, 서 순서


    private static int bfs(int R, int C, int number) {
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{R,C});
        visited[R][C] = number;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nc < 0 || nr >= visited.length || nc >= visited[0].length){
                    continue;
                }
                // 이쪽 방향이 뚫린 방향인지 확인.
                if((map[r][c] & heading[d]) != 0){
                    continue;
                }
                if(visited[nr][nc] != 0){
                    continue;
                }
                visited[nr][nc] = number;
                q.add(new int[]{nr, nc});
                area++;
            }
        }
        // 1. 가장 넓은 방의 넓이
        result[1] = Math.max(result[1], area);
        return area;
    }
}