import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		landNumChange(new boolean[N][N]);
//		printmap();
		// 다리 지어주기
		int min = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] > 0 && isendofland(r, c)) {
					int dis = bfs(r, c, new boolean[N][N]);
					if (dis == 0)
						continue;
					min = Math.min(min, dis);
				}
			}
		}
		System.out.println(min);
	}

	public static boolean isendofland(int r, int c) {
		for (int d = 0; d < dc.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!isarrin(nr, nc))
				continue;
			if (map[nr][nc] == 0) {
				return true;
			}
		}

		return false;
	}

	private static int bfs(int R, int C, boolean[][] v) {
		Queue<int[]> q = new LinkedList<>();
		v[R][C] = true;
		q.add(new int[] { R, C, 0 });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			int cnt = temp[2];

			if (map[r][c] != 0 && map[r][c] != map[R][C])
				return cnt - 1;
			for (int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!isarrin(nr, nc))
					continue;
				if (v[nr][nc])
					continue;
				if (map[nr][nc] == map[R][C])
					continue;
				v[nr][nc] = true;
				q.add(new int[] { nr, nc, cnt + 1 });
			}
		}
		return 0;
	}

	public static boolean isarrin(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N)
			return false;

		return true;
	}

	public static void printmap() {
		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	private static void landNumChange(boolean[][] v) {
		Queue<int[]> q = new LinkedList<>();
		int num = 2;
		boolean count = false;
		for (int R = 0; R < N; R++) {
			for (int C = 0; C < N; C++) {
				count = false;
				if (!v[R][C] && map[R][C] == 1) {
					map[R][C] = num;
					v[R][C] = true;
					count = true;
					q.add(new int[] { R, C });
				}
				while (!q.isEmpty()) {
					int[] temp = q.poll();
					int r = temp[0];
					int c = temp[1];
					for (int d = 0; d < dr.length; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (!isarrin(nr, nc))
							continue;
						if (map[nr][nc] == 1) {
							v[nr][nc] = true;
							map[nr][nc] = num;
							q.add(new int[] { nr, nc });
						}
					}
				}
				if (count)
					num++;
			}
		}

	}

}