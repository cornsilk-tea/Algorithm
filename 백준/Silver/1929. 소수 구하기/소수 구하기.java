import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] table = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            table[i] = i;
        }
        table[1] = 0;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(table[i] == 0) continue;
            for (int j = i+i; j <= N; j+=i) {
                table[j] = 0;
            }
        }
        for(int i : table){
            if(i != 0 && i >= M)
                System.out.println(i);
        }
    }
}