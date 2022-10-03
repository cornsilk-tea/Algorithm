import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] sel = new int[7];
	static int[] result = new int[7];
	public static void main(String[] args) {
		arr = new int[9];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Combination(0, 0);
	}

	public static void Combination(int start, int k) {
		if (k == 7) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if (sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}
		for (int i = start; i < arr.length; i++) {
			sel[k] = arr[i];
			Combination(i + 1, k + 1);
		}
	}

}