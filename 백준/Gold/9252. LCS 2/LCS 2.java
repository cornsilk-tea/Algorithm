import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        String B = br.readLine();
        // 이 배열은 각 위치에서 가장 긴 증가하는 부분 수열의 길이를 저장한다.
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int r = 1; r <= A.length(); r++) {
            for (int c = 1; c <= B.length(); c++) {
                if(A.charAt(r-1) == B.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1] + 1;
                }
                else{
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }
        bw.write(String.valueOf(dp[A.length()][B.length()]));
        bw.newLine();
//        for(int[] a : dp){
//            System.out.println(Arrays.toString(a));
//        }
        // LCS출력
        StringBuilder sb = new StringBuilder();
        int r = A.length();
        int c = B.length();
        while(r > 0 && c > 0){
            if(A.charAt(r-1) == B.charAt(c-1)){
                sb.append(A.charAt(r-1));
                r--;
                c--;
            }
            else{
                if(dp[r-1][c] > dp[r][c-1]){
                    r--;
                }
                else{
                    c--;
                }
            }
        }
        bw.write(sb.reverse().toString());
        bw.close();
    }
}