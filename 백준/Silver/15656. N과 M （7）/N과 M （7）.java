import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr, sel;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		Permutation(0, 0);
		System.out.println(sb);
	}

	private static void Permutation(int idx, int cnt) {
		if (cnt == M) {
			sb.append(Arrays.toString(sel).replaceAll("[\\]\\,\\[]", "") + "\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			sel[cnt] = arr[i];
			Permutation(i, cnt + 1);
		}
	}

}