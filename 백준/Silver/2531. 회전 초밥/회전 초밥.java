import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, d, k, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 회전 초밥 벨트에 놓인 접시의 수
        N = Integer.parseInt(st.nextToken());
        // 초밥의 가짓수
        d = Integer.parseInt(st.nextToken());
        // 연속해서 먹는 접시의 수
        k = Integer.parseInt(st.nextToken());
        // 쿠폰 번호
        c = Integer.parseInt(st.nextToken());
        //  N개의 줄에는 벨트의 한 위치부터 시작하여 회전 방향을 따라갈 때 초밥의 종류
        // 1 이상 d 이하의 정수가 각 줄마다 하나씩 주어짐
        arr = new int[N+k];
        for(int i = 0; i < N+k; i++){
            if(i >= N){
                arr[i] = arr[i-N];
            }
            else{
                arr[i] = Integer.parseInt(br.readLine());
            }
        }
        int[] check = new int[d + 1];
        int kind = 0;
        /*
            문제 해결 핵심
            서로 다른 초밥의 종류를 슬라이딩 윈도우로 계산해라.
         */
        for(int i = 0; i < k; i++){
            check[arr[i]] += 1;
            if(check[arr[i]] == 1){
                kind += 1;
            }
        }
        int max = check[c] == 0 ? kind + 1 : kind;

        for(int i = k; i < N+k; i++){
            check[arr[i]] += 1;
            if(check[arr[i]] == 1){
                kind += 1;
            }
            check[arr[i - k]] -= 1;
            if(check[arr[i - k]] == 0){
                kind -= 1;
            }

            max = Math.max(max, check[c] == 0? kind+1 : kind);
        }
        System.out.println(max);
    }
}