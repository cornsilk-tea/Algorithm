import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<int[]> virusList;
	static int result;
	static int[][] testCase = { { 0, 0, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 2 }, { 1, 1, 1, 0, 0, 2 },
			{ 0, 0, 0, 1, 0, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virusList = new ArrayList<>();
		result = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					virusList.add(new int[] { r, c });
				}
			}
		}
		// 벽쌓기 시작(dfs)
		placeWall(0, 0, 0);
//		printmap();
		System.out.println(result);
	}

	private static void printmap(int[][] map) {
		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void placeWall(int i, int j, int cnt) {
		// 처음부터 돌아가면서 벽을 쌓는 작업을 해준다.
		if (cnt == 3) {
			// 여기서 바이러스들 bfs시작해줌
			// 최대값 갱신
			result = Math.max(result, virusSpread());
			return;
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 방문 안했고 해당좌표가 비어있다면
				if (map[r][c] == 0) {
					map[r][c] = 1;
					placeWall(r, c + 1, cnt + 1);
					map[r][c] = 0;
				}
			}
		}

	}

	private static int countZero(int[][] map) {
		int cnt = 0;
		for (int[] a : map) {
			for (int b : a) {
				if (b == 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static int[][] copymap(int[][] map) {
		int[][] copymap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		return copymap;
	}

	private static boolean isarrout(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M) {
			return true;
		}
		return false;
	}

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static int virusSpread() {
		// 바이러스는 2 <= 바이러스 <= 10이다
		int virusCnt = virusList.size();
		Queue<int[]> q = new LinkedList<int[]>();
		// 임시 맵을 생성해서 작업을해줘야 한다.
		int[][] tempmap = copymap(map);
		for (int i = 0; i < virusCnt; i++) {
			// 이 안에서 조건을 만족할때까지 반복해준다.
			int br = virusList.get(i)[0];
			int bc = virusList.get(i)[1];
			q.add(new int[] { br, bc });
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				int r = temp[0];
				int c = temp[1];
				for (int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					// 범위 초과하면 꺼지셈~
					if (isarrout(nr, nc))
						continue;
					// 방문 안했고 해당하는곳이 2이거나 0일경우에만 이동
					if (tempmap[nr][nc] == 0) {
						tempmap[nr][nc] = 2;
						q.add(new int[] { nr, nc });
					}
				}
			}
		}
		return countZero(tempmap);

	}

}