import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt(st.nextToken());
            // 이진 탐색 시작
            int start = 0;
            int end = arr.length-1;
            boolean flag = false;
            while(start <= end){
                int midIndex = (start+end)/2;
                if(arr[midIndex] > find){
                    end = midIndex -1;
                }
                else if(arr[midIndex] < find){
                    start = midIndex + 1;
                }
                else{
                    flag = true;
                    break;
                }
            }
            if(flag)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}