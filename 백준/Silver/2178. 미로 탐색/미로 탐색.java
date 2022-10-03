import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void print(int[][] map) {
		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	public static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
			}
		}
//		print(map);
		// 본격적으로 시작~
		bfs(0, 0, new boolean[N][M]);
		System.out.println(map[N-1][M-1]);
//		print(map);
	}

	static int cnt = 0;
	static int result = Integer.MAX_VALUE;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	private static void bfs(int r, int c, boolean[][] v) {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] { r, c });
		v[r][c] = true;
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				int[] p = Q.poll();
//				System.out.println(Arrays.toString(p));

				// logic part
				// ~~ 경우가 되면 나 break;
//				if (p[0] == N - 1 & p[1] == M - 1) {
//					System.out.println(cnt);
//					result = Math.min(result, cnt);
//				}

				for (int d = 0; d < 4; d++) {
					int nr = p[0] + dr[d];
					int nc = p[1] + dc[d];
					if (isarrin(nr, nc) && !v[nr][nc] && map[nr][nc] == 1) {
						v[nr][nc] = true;
						map[nr][nc] = map[p[0]][p[1]] + 1;
//						System.out.println(nr+" "+nc);
						Q.add(new int[] { nr, nc });
					}
				}
			}
		}
	}// bfs

	public static boolean isarrin(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return false;
		return true;
	}

}