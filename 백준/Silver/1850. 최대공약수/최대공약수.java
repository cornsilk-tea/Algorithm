import java.io.*;
import java.util.StringTokenizer;

/*********************************************************************
 *Title : 최대공약수
 *Description : 모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다.
 * 이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.
 * 예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고,
 * B가 111111인 경우에는 최대공약수가 111이다.
 *Input : 첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다.
 * 입력되는 수는 2^63보다 작은 자연수이다.
 *Output : 첫째 줄에 A와 B의 최대공약수를 출력한다.
 * 정답은 천만 자리를 넘지 않는다.
 *********************************************************************/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long result = gcd(A, B);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(result > 0){
            bw.append('1');
            result--;
        }
        bw.flush();
        bw.close();
    }
    public static long gcd(long a, long b){
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
}