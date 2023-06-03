import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, M, maxCnt;
//    static int[] dp;
//    static boolean[][] map;
    static List<List<Integer>> listMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        map = new boolean[10001][10001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        listMap = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            listMap.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
//            map[B][A] = true;
            listMap.get(B).add(A);
        }
        maxCnt = 0;
        int[] cntArray = new int[N+1];
        for(int computerNum = 1; computerNum <= N; computerNum++){
            int tempCnt = bfs(computerNum, new boolean[N+1]);
            maxCnt = Math.max(maxCnt, tempCnt);
            cntArray[computerNum] = tempCnt;
        }
        String result = "";
        for(int i = 1; i <= N; i++){
            if(maxCnt == cntArray[i]){
                result += i + " ";
            }
        }
        System.out.println(result.trim());
//        System.out.println(Arrays.toString(cntArray));
    }

    private static int bfs(int computerNum, boolean[] v) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(computerNum);
        v[computerNum] = true;
        while(!q.isEmpty()){
            int currComputerNum = q.poll();
            for(int nextComputerNum : listMap.get(currComputerNum)){
                if(v[nextComputerNum] == false){
                    v[nextComputerNum] = true;
                    q.add(nextComputerNum);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}