import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static List<List<int[]>> list;
    static int[] check;
    static int V, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int countToken = st.countTokens()-2;
            int start = Integer.parseInt(st.nextToken());
            for (int j = 0; j < countToken/2; j++) {
                int end = Integer.parseInt(st.nextToken());
                int endLength = Integer.parseInt(st.nextToken());
                list.get(start).add(new int[]{end, endLength});
                list.get(end).add(new int[]{start, endLength});
            }
            st.nextToken();
        }
        check = new int[V+1];
        answer = 1;
        // bfs
        bfs(1);
//        System.out.println(Arrays.toString(check));
        int max = 1;
        for (int i = 1; i < V+1; i++) {
            if(check[max] < check[i]){
                max = i;
            }
        }
        check = new int[V+1];
        bfs(max);
        for(int i : check){
            max = Math.max(i, max);
        }
        System.out.println(max-1);
    }

    private static void bfs(int i) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, 1});
        check[i] = 1;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int sNode = curr[0];
            int sCnt = curr[1];
            for(int[] nNode : list.get(sNode)){
                if(check[nNode[0]] == 0){
                    check[nNode[0]] = check[sNode] + nNode[1];
                    q.add(nNode);
                }
            }
        }
    }
}