import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*********************************************************************
 *Title : 칵테일
 *Description : august14는 세상에서 가장 맛있는 칵테일이다.
 * 이 칵테일을 만드는 정확한 방법은 아직 세상에 공개되지 않았지만, 들어가는 재료 N개는 공개되어 있다.
 * 경근이는 인터넷 검색을 통해서 재료 쌍 N-1개의 비율을 알아냈고,
 * 이 비율을 이용해서 칵테일에 들어가는 전체 재료의 비율을 알아낼 수 있다.
 * 총 재료 쌍 N-1개의 비율이 입력으로 주어진다.
 * 이때, 칵테일을 만드는데 필요한 각 재료의 양을 구하는 프로그램을 작성하시오.
 * 이때, 필요한 재료의 질량을 모두 더한 값이 최소가 되어야 한다. 칵테일을 만드는 재료의 양은 정수이고,
 * 총 질량은 0보다 커야한다.비율은 "a b p q"와 같은 형식이고, a번 재료의 질량을 b번 재료의 질량으로 나눈 값이 p/q라는 뜻이다.
 *Input : 첫째 줄에 august14를 만드는데 필요한 재료의 개수 N이 주어지며, N은 10보다 작거나 같은 자연수이다.
 * 둘째 줄부터 N-1개의 줄에는 재료 쌍의 비율이 한 줄에 하나씩 주어지는데, 문제 설명에 나온 형식인 "a b p q"로 주어진다.
 * 재료는 0번부터 N-1까지이며, a와 b는 모두 N-1보다 작거나 같은 음이 아닌 정수이다. p와 q는 9보다 작거나 같은 자연수이다.
 *Output : 첫째 줄에 칵테일을 만드는데 필요한 각 재료의 질량을 0번 재료부터 순서대로 공백으로 구분해 출력한다.
 *********************************************************************/
public class Main {
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean[] visited;
    static long[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long ngcd = D[0];
        for(int i = 1; i < N; i++){
            ngcd = gcd(ngcd, D[i]);
        }
        for(int i = 0; i < N; i++){
            System.out.print(D[i] / ngcd + " ");
        }
    }
    public static long gcd(long a, long b){
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
    public static void DFS(int Node){
        visited[Node] = true;
        for(cNode i : A[Node]){
            int next = i.getB();
            if(visited[next] == false){
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}
class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}