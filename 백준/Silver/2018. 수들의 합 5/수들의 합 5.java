import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1; // N~N의 합이 N이기때문
        int[] table = new int[N+2];
        int start = 1;
        int end = 1;
        // 합 테이블 만들기
        for (int i = 1; i <= N; i++) {
            table[i] = table[i-1] + i;
        }
//        System.out.println(Arrays.toString(table));
        while(start <= end){
            if(start == N && end == N) break;
            if(table[end] - table[start-1] == N){
                // 연속된 수가 N이 됐으므로 answer++;
                answer++;
                // 그리고 다음으로 넘어갈 수 있게 end++
                if(end != N) end++;
            }
            // 연속된 수의 합이 N보다 작다면?
            else if(table[end] - table[start-1] < N){
                // end를 뒤로 넘겨준다.
                if(end != N) end++;
            }
            // 연속된 수의 합이 N보다 크다면?
            else{
                // start를 뒤로 넘겨준다.
                start++;
            }
        }
        System.out.println(answer);
    }
}