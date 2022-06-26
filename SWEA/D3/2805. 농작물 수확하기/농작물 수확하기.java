import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 각 테스트 케이스에는 농장의 크기 N과 농장 내 농작물의 가치가 주어진다.
			int N = Integer.parseInt(br.readLine());

			int sum = 0;
			int half = N / 2;
			int startX = 0;
			int endX = 0;
			int wide = 0;
			for (int i = 0; i < N; i++) {
				startX = half - wide;
				endX = half + wide;

				char[] temp = br.readLine().toCharArray();
				for (int j = startX; j <= endX; j++) {
					sum += temp[j] - '0';
				}
				if (i < half) {
					wide++;
				} else {
					wide--;
				}
			}

			// 각 줄은 '#t'로 시작하고, 공백으로 농장의 규칙에 따라 얻을 수 있는 수익을 출력한다.
			System.out.printf("#%d %d\n", tc, sum);
		}

	}

}