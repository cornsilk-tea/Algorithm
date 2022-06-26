import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// pq를 사용하여 정렬할것이기에 이 클래스에 컴페어러블을 임플해준다.
	static class Number implements Comparable<Number> {
		// 문자가 들어올변수
		String stringnum;
		// 숫자가 들어올 변수
		int num;

		// 일반적인 생성자
		public Number(String stringnum, int num) {
			this.stringnum = stringnum;
			this.num = num;
		}

		@Override
		public int compareTo(Number o) {
			// 사전순으로 정렬해주는 메소드
			return stringnum.compareTo(o.stringnum);
		}

	}

	// 숫자를 가지고 문자를 매칭시키기 위해 0~9까지의 영어 배열을 만들어준다.
	static String[] enNumbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws IOException {
		// pq사용을 위해 생성
		PriorityQueue<Number> pq = new PriorityQueue<>();
		// 입력값을 받기위한 버퍼리더 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력값이 띄어쓰기로 나뉘어있기때문에 따로 사용하기위해 STR생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정렬할 숫자의 시작값
		int start = Integer.parseInt(st.nextToken());
		// 정렬할 숫자의 마지막값
		int end = Integer.parseInt(st.nextToken());
		// 정렬할 숫자의 시작값부터 마지막값까지 따져서 pq안에 Number로 넣기 위한 반복문
		for (int i = start; i <= end; i++) {
			// 만약 숫자가 한자리수라면 그냥 enNumbers에 매칭시켜 넣어줘도 된다.
			if (i < 10) {
				// 위 조건대로 pq에 넣어줌
				pq.add(new Number(enNumbers[i], i));
			} else {
				// 숫자는 2자리수까지만 나오기 때문에 숫자의 첫번째값과 두번째값을 일단 뽑아준다.
				// 뒷자리
				int second = i % 10;
				// 앞자리
				int first = i / 10 % 10;
				// 그리고 그 앞자리 뒷자리 숫자들로 문자열을 만들어 새로 넣어준다.
				pq.add(new Number(enNumbers[first] + enNumbers[second], i));
			}
		}
		// 10줄씩 끊어 출력하기위한 변수
		int cnt = 0;
		// pq가 다 빌때까지 반복
		while (!pq.isEmpty()) {
			// 0부터 시작했으니 9가되면 10개출력할차례라는것이다.
			if (cnt == 9) {
				// 출력해주고
				System.out.println(pq.poll().num);
				// 다시 처음부터 카운트를 세준다.
				cnt = 0;
			} else {
				// 위 조건에 만족하지 못할경우 아직 10번 프린트 안했으니 그냥 프린트해준다.
				System.out.print(pq.poll().num + " ");
				cnt++;
			}
		}
	}

}