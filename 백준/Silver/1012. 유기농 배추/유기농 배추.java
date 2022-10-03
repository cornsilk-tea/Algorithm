import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] table;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			table = new int[N + 1][M + 1];
			v = new boolean[N + 1][M + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				table[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			int result = 0;
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table[0].length; j++) {
					if (table[i][j] == 1 && v[i][j] == false) {
						v[i][j] = true;
						result++;
						dfs(i, j);
					}
				}
			}
			System.out.println(result);
		}

	}

	// 상 우 하 좌
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < table.length && nc < table[0].length) {
				if (table[nr][nc] == 1 && v[nr][nc] == false) {
					v[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
	}

}