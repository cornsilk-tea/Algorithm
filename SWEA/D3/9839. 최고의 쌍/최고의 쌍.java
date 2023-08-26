import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                numList.add(Integer.parseInt(st.nextToken()));
            }
            // 숫자를 큰 수부터 정렬해야 가장 큰 값을 빨리 찾기 쉽다.
            Collections.sort(numList, Collections.reverseOrder());
            int maxValue = -1; // 디폴트값
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int mulValue = numList.get(i) * numList.get(j);
                    if (checkSequence(mulValue)) {
                        maxValue = Math.max(maxValue, mulValue);
                    }
                }
            }
            sb.append(maxValue).append("\n");
        }
        sb.deleteCharAt(sb.length()-1); // sb사용시 가장 마지막에 \n이 들어가면 틀림.
        System.out.println(sb.toString());
    }

    // 해당 숫자가 10진수로 증가하면서 연속적인 수인지 판단
    private static boolean checkSequence(int num) {
        // 가장 끝 자리 숫자를 저장
        int prevDigit = num % 10;
        num /= 10;
        while (num > 0) { // 해당 숫자를 기준으로 순차적으로 다음 숫자가 작아지는지 확인
            int curDigit = num % 10;
            if (curDigit != prevDigit - 1) {
                return false;
            }
            prevDigit = curDigit;
            num /= 10;
        }
        return true;
    }
}