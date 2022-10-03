import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] table;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		for (int i = 0; i < table.length; i++) {
			int cnt = 0;
			String temp = br.readLine();
			for (int j = 0; j < table.length; j++) {
				table[i][j] = Integer.parseInt(temp.charAt(cnt++) + "");
			}
		}
		makeTree(0, 0, N);
	}

	private static void makeTree(int r, int c, int n) {
		int temp = table[r][c];
		boolean check = true;
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (table[i][j] != temp) {
					check = false;
				}
			}
		}
		if (check == true | n == 1) {
			System.out.print(table[r][c]);
			return;
		}

		int nn = n / 2;
		System.out.print("(");
		makeTree(r, c, nn);
		makeTree(r, c + nn, nn);
		makeTree(r + nn, c, nn);
		makeTree(r + nn, c + nn, nn);
		System.out.print(")");
	}

}