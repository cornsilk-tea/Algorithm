import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	static int[][] table;
	static boolean[][] v;
	static int result, num;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < table.length; i++) {
			int cnt = 0;
			String temp = br.readLine();
			for (int j = 0; j < table.length; j++) {
				table[i][j] = Integer.parseInt(temp.charAt(cnt++) + "");
			}
		}
		num = 0;
		list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j] && table[i][j] == 1) {
					result = 0;
					dfs(i, j);
					list.add(result);

				}
			}
		}
		System.out.println(list.size());
		list.sort(Comparator.naturalOrder());
		for (int a : list) {
			System.out.println(a);
		}

	}

	public static boolean isarrin(int r, int c) {
		if (r < 0 || c < 0 || r >= table.length || c >= table.length) {
			return false;
		}

		return true;
	}

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static void dfs(int r, int c) {
		v[r][c] = true;
		result++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 배열 내부에 있다면 dfs다시 시작
			if (isarrin(nr, nc) && table[nr][nc] == 1 && !v[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

}