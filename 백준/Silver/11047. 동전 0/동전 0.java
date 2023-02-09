import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer, N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int stdAmount = K;
        int cnt = 0;
//        System.out.println(Arrays.toString(arr));
        for (int i = N - 1; i >= 0; i--) {
                if(arr[i] > K) continue;
                //같거나 작은 동전 찾음
                cnt += stdAmount/arr[i];
                stdAmount %= arr[i];
                if(stdAmount == 0) break;
        }
        System.out.println(cnt);
    }

}