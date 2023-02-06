import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(A));
        Stack<Integer> stack = new Stack<>();
        int[] resultArr = new int[N];
        Arrays.fill(resultArr,-1);
        stack.add(0);
        for (int i = 1; i < N; i++) {
            // 스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                resultArr[stack.pop()] = A[i];
            }
            stack.push(i);
        }
//        while(!stack.empty()){
//            // 반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지
//            resultArr[stack.pop()] = -1;
//        }
        System.out.println(Arrays.toString(resultArr).replaceAll("[\\[\\],]",""));
    }
}