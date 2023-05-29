import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long K, cntK;
    static int problemNo;
    static int[] targetPermutation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 두개의 소 문제 중 어떤것인지 확인하는 변수
        problemNo = Integer.parseInt(st.nextToken());
        targetPermutation = new int[N];
        if(problemNo == 1){
            // K가 int범위를 초과할 수 있으므로, long으로 받아준다.
            // ex
            // 20
            // 1 2432902008176640000
            K = Long.parseLong(st.nextToken());
        }
        else if(problemNo == 2){
            int idx = 0;
            while(st.hasMoreTokens()){
                targetPermutation[idx++] = Integer.parseInt(st.nextToken());
            }
            // 20번째 줄과 마찬가지로 int범위를 초과할 수 있으므로, long으로 받아준다.
            cntK = 0;
        }
        // 본 코드
        // 우선 problemNo가 1인경우만 구현하기
        dfs(0, new int[N], new boolean[N+1]);
    }
    private static boolean dfs(int depth, int[] permutation, boolean[] v){
        boolean flag = false;
        // 소문제의 번호가 1번인지 2번인지에 따라 다른 로직을 수행한다.
        // 1번일 경우 k번째 순열을 출력한다.
        if(problemNo == 1){
            // 종료조건
            if(depth == N){
//                System.out.println("종료조건 도착");
                System.out.println(Arrays.toString(permutation).replaceAll("[\\[\\],]", ""));
                return true;
            }
            // 본문
            for(int currNum = 1; currNum <= N; currNum++){
                // 이미 방문했던 숫자라면 건너뛴다.
                if(v[currNum] == true){
                    continue;
                }
                // K를 판별하기 위해선 어떻게해야할까?
                // N개의 숫자 -currNum을 factorial을 통해 구해 임시값에 저장해준다.
                long temp = factorial(N-depth-1);
                // K가 temp보다 크다면 현재 반복문 다음에 나오는 숫자로 넘어가야한다.
                if(K > temp){
                    K -= temp;
                    continue;
                }
                // 만약 K가 temp보다 작거나 같다면, 현재숫자로 시작하는 순열 안아 K번째 순열이 있다.
                else if(K <= temp){
                    // 현재 수를 현재 depth위치의 permutation에 넣어준다.
                    permutation[depth] = currNum;
                    // 방문처리
                    v[currNum] = true;
                    // 다음 depth로 넘어간다.
                    flag = dfs(depth+1, permutation, v);
                    if(flag == true){
                        return true;
                    }
                }
            }
        }
        // 2번일 경우 targerPermutation이 몇번째 함수인지 출력해준다.
        else if(problemNo == 2){
            // 종료조건
            if(depth == N){
                cntK++;
                System.out.println(cntK);
                return true;
            }
            // 본문
            // targetPermutation의 depth번째 숫자를 찾으며, 만약 현재 위치의 수가 depth번째 숫자와 다르다면, cntK에 factorial(N-depth-1)을 더해준다.
            // 그 후 continue로 해당하는 숫자를 찾을때까지 반복해준다.
            for(int currNum = 1; currNum <= N; currNum++){
                // 우선 방문했던 숫자라면 넘겨준다.
                if(v[currNum] == true){
                    continue;
                }
                // 만약 현재 숫자가 depth번째 숫자와 다르다면 cntK에 factorial(N-depth-1)을 더해준다.
                if(currNum != targetPermutation[depth]){
                    cntK += factorial(N-depth-1);
                    continue;
                }
                // 만약 현재 숫자가 depth번째 숫자와 같다면, 현재 숫자를 permutation에 넣어주고, 방문처리를 해준다.
                else if(currNum == targetPermutation[depth]){
                    permutation[depth] = currNum;
                    v[currNum] = true;
                    flag = dfs(depth+1, permutation, v);
                    if(flag == true){
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    // factorial 함수
    private static long factorial(int n){
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}