import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[][] table;
	static boolean[] v;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		table = new char[R][C];
		v = new boolean[26];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int c = 0; c < C; c++) {
				table[r][c] = temp.charAt(c);
			}
		}

		dfs(0, 0, 1);
		System.out.println(result);

	}

	public static boolean isarrin(int r, int c) {
		if (r < 0 || c < 0 || r >= table.length || c >= table[0].length) {
			return false;
		}
		return true;
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	private static void dfs(int r, int c, int cnt) {
		v[table[r][c] - 'A'] = true;
		result = Math.max(result, cnt);
//		printboolean();
//		System.out.println(cnt);
		if (cnt == 26) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isarrin(nr, nc) && v[table[nr][nc] - 'A'] == false) {
//				v[table[r][c] - 'A'] = true;
				dfs(nr, nc, cnt + 1);
//				v[table[r][c] - 'A'] = false;
			}
		}
		v[table[r][c] - 'A'] = false;

	}

	public static void printboolean() {
		for (boolean a : v) {
			System.out.print((a ? 1 : 0) + " ");
		}
		System.out.println();
	}

}