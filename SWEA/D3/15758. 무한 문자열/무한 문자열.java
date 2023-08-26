import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(a.length() == b.length()){
                sb.append(a.equals(b) ? "yes": "no").append("\n");
                continue;
            }
            // 두 단어 길이의 최소공배수를 구함
            int lcmLength = lcm(a.length(), b.length());
            String extendedA = extendString(a, lcmLength);
            String extendedB = extendString(b, lcmLength);
            sb.append(extendedA.equals(extendedB) ? "yes": "no").append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    // 문자열 s를 길이가 최소공배수 n이 될 때까지 반복
    private static String extendString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    // a,b의 최소공배수 
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // a,b의 최대공약수
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}