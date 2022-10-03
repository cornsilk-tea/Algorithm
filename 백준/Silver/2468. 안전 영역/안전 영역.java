import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int maxNum = 0;
	static int[][] table;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				table[r][c] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, table[r][c]);
			}
		}
		int result = 0;
		for (int i = 0; i <= maxNum; i++) {
			int tempresult = 0;
			v = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (table[r][c] > i && v[r][c] == false) {
						v[r][c] = true;
						tempresult++;
						dfs(r, c, i);
					}
				}
			}
//			System.out.println(i);
//			for (boolean[] a : v) {
//				for (boolean b : a) {
//
//					System.out.print((b ? 1 : 0) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(tempresult);
//			System.out.println();
			result = Math.max(result, tempresult);
		} // for (int i = 1; i < maxNum; i++)
		System.out.println(result);

	}

	// 상 우 하 좌
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	private static void dfs(int r, int c, int i) {
		for (int n = 0; n < 4; n++) {
			int nr = r + dr[n];
			int nc = c + dc[n];

			if (nr >= 0 && nc >= 0 && nr < table.length && nc < table.length) {
				if (table[nr][nc] > i && v[nr][nc] == false) {
					v[nr][nc] = true;
					dfs(nr, nc, i);
				}
			}
		}

	}

}