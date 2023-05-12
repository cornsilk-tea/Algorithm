import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static long M;
    static long[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long highest = 0;
        table = new long[N];
        for(int i = 0; i < N; i++){
            table[i] = Integer.parseInt(st.nextToken());
            highest = Math.max(highest, table[i]);
        }
        max = 0;
        // 전체 이분탐색 시작
        long left = 0;
        long right = highest;
        // 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
        while(left <= right){
            long mid = (left + right) /2;
            long sum = 0;
            for(long tree : table){
                if(tree > mid){
                    sum += tree-mid;
                }
            }
            if(sum >= M){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(right);
    }
}
