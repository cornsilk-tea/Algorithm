import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < meetings.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		List<Meeting> result = getSchedule(meetings);
		System.out.println(result.size());

	}

	public static List<Meeting> getSchedule(Meeting[] meetings) {

		ArrayList<Meeting> result = new ArrayList<Meeting>();
		// 회의 목록을 종료시간 기준으로 오름차순, 종료시간이 같다면 시작시간 기준으로 오름차순 정렬
		Arrays.sort(meetings);
		result.add(meetings[0]); // 첫회의 추가(종료시간이 가장 빠른 회의)

		for (int i = 1, size = meetings.length; i < size; i++) {
			// 직전회의의 종료시간과 현재회의의 시작시간 비교
			if (result.get(result.size() - 1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
	}
}