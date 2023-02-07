import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean answer;
    static int N,M;
    static List<List<Integer>> list;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
         answer = false;
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if(answer){
                break;
            }
        }
        System.out.println(answer?1:0);
    }

    private static void dfs(int currNode, int cnt) {
        if(cnt == 5){
            answer = true;
            return;
        }
        check[currNode] = true;
        for(int nextNode : list.get(currNode)){
            if(check[nextNode] == false){
                dfs(nextNode, cnt+1);
            }
        }
        check[currNode] = false;
    }

}