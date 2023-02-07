import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static List<List<Integer>> list;
    static boolean[] check;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
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
        for (int i = 0; i < N+1; i++) {
            list.get(i).sort(Comparator.naturalOrder());
        }
        check = new boolean[N+1];
        answer = "";
        dfs(V);
        System.out.println(answer);
        Arrays.fill(check, false);
        answer = "";
        bfs(V);
        System.out.println(answer);
    }

    private static void dfs(int node) {
        answer += node+" ";
        check[node] = true;
        for(int nextNode : list.get(node)){
            if(check[nextNode] == false){
                dfs(nextNode);
            }
        }
    }
    private static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        check[node] = true;
        while(!q.isEmpty()){
            int currNode = q.remove();
            answer += currNode +" ";
            for(int nextNode : list.get(currNode)){
                if(check[nextNode] == false){
                    check[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
    }
}