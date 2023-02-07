import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
//        List<Integer>[] list = new ArrayList[N+1];
//        for (int i = 0; i < N; i++) {
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            list[start].add(end);
//        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
        int answer = 0;
        boolean[] check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                answer++;
                dfs(list, i, check);
            }
        }
        System.out.println(answer);

    }

    private static void dfs(List<List<Integer>> list, int i, boolean[] check) {
        if (check[i]) {
            return;
        }
        check[i] = true;
        for(int j : list.get(i)){
            if(check[j] == false){
                dfs(list, j, check);
            }
        }
    }
}