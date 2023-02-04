import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stLine.nextToken());
        int M = Integer.parseInt(stLine.nextToken());
        stLine = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stLine.nextToken());
            if(i != 0) arr[i] += arr[i-1];
        }
        for (int tc = 0; tc < M; tc++) {
            stLine = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stLine.nextToken())-1;
            int j = Integer.parseInt(stLine.nextToken())-1;
            int result = i==0?arr[j]:arr[j]-arr[i-1];
            System.out.println(result);
        }
    }
}