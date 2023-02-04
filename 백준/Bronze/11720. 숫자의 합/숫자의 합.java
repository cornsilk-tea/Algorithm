import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int answer = 0;
        for(char c : arr){
            answer += Character.getNumericValue(c);
        }
        bw.write(String.valueOf(answer));
        bw.close();

    }
}