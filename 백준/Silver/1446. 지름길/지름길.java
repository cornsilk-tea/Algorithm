import java.util.*;
import java.io.*;

public class Main {
    static class Shortcut implements Comparable<Shortcut> {
        int start;
        int end;
        int dist;
        
        public Shortcut(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Shortcut o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        Shortcut[] shortcuts = new Shortcut[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            
            shortcuts[i] = new Shortcut(start, end, dist);
        }
        
        Arrays.sort(shortcuts);
        
        int[] dp = new int[D+1];
        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i-1] + 1;
            
            for (Shortcut s : shortcuts) {
                if (s.end == i) {
                    dp[i] = Math.min(dp[i], dp[s.start] + s.dist);
                }
            }
        }
        
        System.out.println(dp[D]);
    }
}