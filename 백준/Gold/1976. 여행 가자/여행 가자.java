import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] cityConections;
    static int[] cityRoots, travelPlan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        cityConections = new int[N+1][N+1];
        travelPlan = new int[M + 1];
        cityRoots = new int[N+1];
        StringTokenizer st;
        for(int r = 1; r <= N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++){
                cityConections[r][c] = Integer.parseInt(st.nextToken());
            }
            cityRoots[r] = r;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++){
            travelPlan[i] = Integer.parseInt(st.nextToken());
        }
        for(int r = 1; r <= N; r++){
            for(int c = 1; c <= N; c++){
                if(cityConections[r][c] == 1){
                    union(r, c);
                }
            }
        }
        int firstCityRoot = find(travelPlan[1]);
        for(int i = 2; i < travelPlan.length; i++){
            if(firstCityRoot != find(travelPlan[i])){
                bw.write("NO");
                bw.flush();
                return;
            }
        }
        bw.write("YES");
        bw.flush();
    }

    private static void union(int city1, int city2) {
        city1 = find(city1);
        city2 = find(city2);
        if(city1 != city2){
            cityRoots[city2] = city1;
        }
    }

    private static int find(int city) {
        return city == cityRoots[city] ? city : (cityRoots[city] = find(cityRoots[city]));
    }
}