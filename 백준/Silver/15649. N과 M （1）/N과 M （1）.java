import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] check;

	public static void main(String[] args) throws IOException {
		// 15649 N과 M (1) - 중복되지 않은 순열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new int[M];
		permutation(0, new boolean[N]);
	}

	public static void permutation(int k, boolean[] v) {
		if (k == M) {
			System.out.println(Arrays.toString(check).replaceAll("[\\]\\,\\[]", ""));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i] == false) {
				v[i] = true;
				check[k] = i + 1;
				permutation(k + 1, v);
				v[i] = false;
			}
		}
	}

}