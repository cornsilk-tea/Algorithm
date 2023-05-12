import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M, result;
    static int[] cards;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        visited = new boolean[N];
        result = 0;
        combination(0, 0);
        System.out.println(result);
    }
    private static void combination(int cnt, int sum){
        if(cnt == 3){
            if(sum <= M)
                result = Math.max(sum, result);
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i] == false){
                visited[i] = true;
                combination(cnt+1, sum + cards[i]);
                visited[i] = false;
            }
        }
    }
}
