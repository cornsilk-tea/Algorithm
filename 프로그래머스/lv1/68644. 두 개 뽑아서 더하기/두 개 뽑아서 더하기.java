import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 결과값을 저장할 answer 배열을 선언
        int[] answer;
        
        // 중복값을 제외하며 숫자의 합을 저장할 Set을 선언.
        Set<Integer> set = new HashSet<>();
        
        // numbers 배열의 원소들을 순회하며 가능한 모든 조합의 합을 구한다.
        for (int i = 0; i < numbers.length; i++) {
            // j를 i+1부터 시작하여 자기 자신과의 합을 제외.
            for (int j = i + 1; j < numbers.length; j++) {
                // numbers[i]와 numbers[j]의 합을 set에 추가.
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // Set의 모든 원소를 int 배열로 변환하고 정렬.
        // 스트림을 사용하여 mapToInt를 통해 Integer 객체를 int로 변환하고,
        // sorted()를 사용하여 오름차순 정렬한 후 toArray()를 통해 배열로 변환.
        answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();
        return answer;
    }
}
