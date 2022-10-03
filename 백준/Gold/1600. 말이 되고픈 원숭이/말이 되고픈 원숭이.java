import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N, M, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
//		print(map);
		bfs(1, 1);

	}

	static class Point {
		int r, c, cnt, k;

		public Point(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}

	}

	static int[] dr = { 1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 0, 0, 1, -1, 1, 2, 2, 1, -1, -2, -2, -1 };

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList<>();
		boolean[][][] v = new boolean[N + 1][M + 1][K + 1];
		Q.add(new Point(r, c, 0, K));
		v[r][c][K] = true;
		int Ans = Integer.MAX_VALUE;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			if (p.r == N && p.c == M) {
				Ans = Math.min(Ans, p.cnt);
				break;
			}
			for (int d = 0; d < (p.k > 0 ? 12 : 4); d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				int nk = d < 4 ? p.k : p.k - 1;
				if (nr >= 1 && nr <= N && nc >= 1 && nc <= M && !v[nr][nc][nk] && map[nr][nc] != 1) {
					v[nr][nc][nk] = true;
					Q.add(new Point(nr, nc, p.cnt + 1, nk));
				}
			}
		}
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}

	private static void print(int[][] map) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}