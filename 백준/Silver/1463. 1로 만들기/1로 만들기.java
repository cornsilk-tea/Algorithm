import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] memo;
	static int N;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		memo = new int[1000001];
		memo[0] = 0;
		memo[1] = 0;
		memo[2] = 1;
		memo[3] = 1;
		memo[4] = 2;
		memo[5] = 3;
		if (N > 5) {
			rec();
			System.out.println(memo[N]);
		} else {
			System.out.println(memo[N]);
		}
//		System.out.println(Arrays.toString(memo));

	}

	private static void rec() {
		for (int i = 6; i <= N; i++) {
//			System.out.print("현재 " + i + "= ");
			int temp1 = Integer.MAX_VALUE;
			int temp2 = Integer.MAX_VALUE;
			int temp3 = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				// 3으로 나뉘어진다면
//				 memo[i] = memo[i/3]+1;
				temp1 = memo[i / 3] + 1;
			}
			if (i % 2 == 0) {
				// 2로 나뉘어진다면
//				 memo[i] = memo[i/2]+1;
				temp2 = memo[i / 2] + 1;
			}
			// 나머지는 1을 빼준다.
//				memo[i] = memo[i - 1] + 1;
			temp3 = memo[i - 1] + 1;

//			System.out.printf("temp1 = %d, temp2 = %d, temp3 = %d\n", temp1, temp2, temp3);
			memo[i] = Math.min(temp1, Math.min(temp2, temp3));
//			System.out.println(memo[i]);
		}

	}

}