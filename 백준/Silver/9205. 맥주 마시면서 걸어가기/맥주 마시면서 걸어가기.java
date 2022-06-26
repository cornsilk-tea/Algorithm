import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static ArrayList<int[]> list;
	static int[][] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			dist = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new int[] { r, c });
			}
			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					dist[i][j] = Math.abs(list.get(i)[1] - list.get(j)[1]) + Math.abs(list.get(i)[0] - list.get(j)[0]);
					if (dist[i][j] > 1000) {
						dist[i][j] = -1;
						dist[j][i] = -1;
					}
				}
			}
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					if (k == i)
						continue;
					for (int j = 0; j < n + 2; j++) {
						if (i == j || j == k)
							continue;
						if (dist[i][k] == -1 || dist[k][j] == -1)
							continue;
						dist[i][j] = 1;
					}
				}
			}
			if (dist[0][n + 1] == -1) {
				System.out.println("sad");
			} else {
				System.out.println("happy");
			}
		}

	}

}