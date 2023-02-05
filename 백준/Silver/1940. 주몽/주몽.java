import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] table = new int[st.countTokens()];
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(table);
//        System.out.println(Arrays.toString(table));
        int s = 0;
        int e = N-1;
        int answer = 0;
        // 양쪽에서 시작하는 투 포인터
        while(s < e){
            int sum = table[s] + table[e];
            if(sum == M){
                answer ++;
                s++;
                e--;
            }
            else if(sum < M){
                s++;
            }
            else{
                e--;
            }
        }
        System.out.println(answer);
    }
}