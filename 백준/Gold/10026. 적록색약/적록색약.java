import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] v;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < map.length; i++) {
			String temp = br.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		// 적록색약이 아닌 사람이 봤을때의 구역의 개수 구하기
		int result01 = 0;
		v = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					dfs01(r, c, map[r][c]);
					result01++;
				}
			}
		}
		System.out.print(result01 + " ");
		// 적록 색약인 사람이 봤을때의 구역의 개수 구하기
		int result02 = 0;
		v = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					dfs02(r, c, map[r][c]);
					result02++;
				}
			}
		}
		System.out.println(result02);
	}

	public static boolean isarrin(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return false;
		}
		return true;
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void dfs01(int r, int c, char color) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isarrin(nr, nc) && map[nr][nc] == color && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs01(nr, nc, color);
			}
		}
	}

	// 적록색약의 컬러판단
	public static boolean checkRGcolor(char firstColor, char secondColor) {
		// 빨간색 또는 초록색일때
		if (firstColor == 'G' | firstColor == 'R') {
			if (secondColor == 'G' | secondColor == 'R') {
				return true;
			}
		}
		if (firstColor == secondColor)
			return true;
		return false;
	}

	public static void dfs02(int r, int c, char color) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isarrin(nr, nc) && checkRGcolor(map[nr][nc], color) && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs02(nr, nc, color);
			}
		}
	}

}