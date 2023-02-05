import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] baseTable = new int[N+1][N+1];
        int[][] sumTable = new int[N+1][N+1];
        // 합배열 저장하기.
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                int num = Integer.parseInt(st.nextToken());
                baseTable[r][c] = num;
                sumTable[r][c] = num + sumTable[r-1][c] + sumTable[r][c-1] - sumTable[r-1][c-1];
            }
        }
//        System.out.println();
//        for(int[] a : baseTable){
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println("--------------------------");
//        for(int[] a : sumTable){
//            System.out.println(Arrays.toString(a));
//        }
        /* (x1, y1)부터 (x2, y2)의 합
            s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[xy-1][y1-1]
        */
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = sumTable[x2][y2] - sumTable[x1-1][y2] - sumTable[x2][y1-1] + sumTable[x1-1][y1-1];
            System.out.println(result);
        }
    }
}