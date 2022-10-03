import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] check;
	static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		// 15652 N과 M (4) - 중복을 허용하는 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new int[M];
		stringBuilder = new StringBuilder();
		Combination(1, 0);
		System.out.println(stringBuilder);
	}

	private static void Combination(int idx, int k) {
		if (k == M) {
			for (int i = 0; i < check.length; i++) {
				stringBuilder.append(check[i] + " ");
			}
			stringBuilder.append("\n");
			return;
		}
		for (int i = idx; i <= N; i++) {
			check[k] = i;
			Combination(i, k + 1);
		}
	}
}