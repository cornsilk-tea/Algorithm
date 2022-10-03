import java.util.Scanner;

public class Main {
//	static int[] sel;
	static int[][] arr;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			int[] sel = new int[i];
			Combination(0, 0, i, sel);
		}
		System.out.println(result);

	}

	private static void Combination(int start, int k, int i, int[] sel) {
		if (k == i) {
			int sumA = 1;// 신맛의 합
			int sumB = 0;// 쓴맛의 합
//			for (int a : sel) {
//				System.out.print(a + " ");
//			}
//			System.out.println();
			for (int j : sel) {
				sumA *= arr[j][0];
				sumB += arr[j][1];
//				System.out.printf("j=%d, 신맛 = %d, 쓴맛 = %d, 차 = %d\n",j, sumA, sumB, sumA-sumB);
			}
			result = Math.min(result, Math.abs(sumA - sumB));
			return;
		}
		for (int j = start; j < arr.length; j++) {
			sel[k] = j;
			Combination(j + 1, k + 1, i, sel);
		}
	}

}