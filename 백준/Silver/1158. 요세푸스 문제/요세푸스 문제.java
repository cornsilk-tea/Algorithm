import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> Q = new LinkedList();
		for (int i = 0; i < N; i++) {
			Q.offer(i);
		}
		int qSize = Q.size();
		System.out.print("<");
		while (!Q.isEmpty()) {
			for (int i = 0; i < M - 1; i++) {
				Q.offer(Q.poll());
			}
			if (Q.size() == 1) {
				System.out.print((Q.poll() + 1) + ">");
				break;
			}
			System.out.print((Q.poll() + 1) + ", ");
		}

	}

}