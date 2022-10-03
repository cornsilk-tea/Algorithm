import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] check;

	public static void main(String[] args) throws IOException {
		// 15650 N과 M (2) - 중복되지 않은 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new int[M];
		permutation(1, 0);
	}

	private static void permutation(int idx, int k) {
		if (k == M) {
			System.out.println(Arrays.toString(check).replaceAll("[\\]\\,\\[]", ""));
			return;
		}
		for (int i = idx; i <= N; i++) {
			check[k] = i;
			permutation(i + 1, k + 1);

		}

	}

}