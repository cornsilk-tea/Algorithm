import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] check;
	static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		// 15650 N과 M (2) - 중복되지 않은 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new int[M];
		stringBuilder = new StringBuilder();
		Combination(0, 0);
		System.out.println(stringBuilder);
	}

	public static void Combination(int idx, int k) {

		if (k == M) {
			for (int a : check) {
				stringBuilder.append(a + " ");
			}
			stringBuilder.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			check[k] = i;
			Combination(idx + 1, k + 1);
		}
	}

}