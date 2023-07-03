import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[Integer.parseInt(br.readLine())+1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i/2; j++){
                dp[i] += 2 * dp[j] * dp[i-j-1];
            }
            if(i%2 == 1){
                dp[i] += dp[i/2] * dp[i/2];
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}