import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int maxScore = -1;
        double answer = 0;
        int[] scoreArr = new int[N];
        for (int i = 0; i < N; i++) {
            String temp = st.nextToken();
            scoreArr[i] = Integer.parseInt(temp);
            maxScore = Math.max(scoreArr[i], maxScore);
        }
        for(int score : scoreArr){
            answer += (double)score/maxScore*100;
        }
        answer /= N;
        bw.write(answer+"");
        bw.flush();
    }
}