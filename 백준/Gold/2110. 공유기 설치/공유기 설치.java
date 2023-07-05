import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, C, minDistance;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[N];
        for(int i = 0; i < N; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);
        boolean[] v = new boolean[N];
        v[0] = true;
        v[N-1] = true;
        minDistance = -1;
        // 우선 공유기는 끝에있는 두 집에는 무조건 설치된다?
        // 그럼 C-2개를 내부에서 탐색하면 되나?
        // 1 2 4 8 9
        // 여기서 [2 4 8] 3개가 남았다고하고,
        // 아니 그럼 이분탐색으로 뭘 찾으라는걸까?
        // 이분탐색으로 거리를 찾으라는건가?
        // 탐색할 거리 범위 지정
        // 시작 범위는 0
        int start = 0;
        // 끝 범위는 가장 끝값 - 첫값
        int end = map[N-1] - map[0];
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            // 가장 첫 위치는 무조건 공유기를 설치한다.
            int cnt = 1;
            // 거리 계산을 위해 이전집을 저장한다.
            int prevHouse = map[0];
            // 현재 탐색중인 거리 mid를 기준으로, 설치할 수 있는 집을 탐색
            for(int i = 1; i < N; i++){
                if(map[i] - prevHouse >= mid){
                    cnt++;
                    prevHouse = map[i];
                }
            }
            if(cnt >= C){
                result = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}