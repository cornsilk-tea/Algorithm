import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] memo;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		memo = new int[1001];
		memo[1] = 1;
		memo[2] = 3;
		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i - 1] + 2 * memo[i - 2]) % 10007;

		}
//		for (int i = 1; i <= n; i++) {
//			System.out.printf("memo[%d] = %d\n", i, memo[i]);
//		}
		System.out.println(memo[n]);
	}
}