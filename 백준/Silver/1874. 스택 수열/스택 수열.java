import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
//        System.out.println(queue);
        int stackNum = 1;
        boolean result = true;
        while (!queue.isEmpty()) {
            // 스텍에 넣는 작업 시작
            int qNum = queue.remove();
            // pointNum이 qNum보다 작다면 qNum이 될때까지 push
            if (stackNum <= qNum) {
                while (stackNum <= qNum) {
                    stack.add(stackNum);
                    stackNum++;
                    sb.append("+\n");
                }
                // 해당하는 수를 찾았을테니 pop한번 해줌
                stack.pop();
                sb.append("-\n");
            }
            //
            else if (stackNum > qNum) {
                int popNum = stack.pop();
                sb.append("-\n");
                if (popNum != qNum) {
                    queue.clear();
                    result = false;
                    System.out.println("NO");
                }
            }
        }
        if(result) System.out.println(sb.toString());
    }
}