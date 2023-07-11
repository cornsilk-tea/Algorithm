import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] cards = new long[n];
        int idx = 0;
        while(st.hasMoreTokens()){
            cards[idx++] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(cards));
        for(int t = 0; t < m; t++){
            Arrays.sort(cards);
//            System.out.println(Arrays.toString(cards));
            long temp = cards[0] + cards[1];
            cards[0] = temp;
            cards[1] = temp;
        }
//        System.out.println(Arrays.toString(cards));
        long result = 0;
        for(long i : cards){
            result += i;
        }
        System.out.println(result);
    }
}