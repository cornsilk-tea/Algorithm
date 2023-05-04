import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        /*
            1번의 방식 = 1-2-3-4-5순
            2번의 방식 = 2-1 / 2-3 / 2-4 / 2-5 / 2-1 순
            3번의 방식 = 3-3 / 1-1 / 2-2 / 4-4 / 5-5 / 3-3 순
            각각의 방식의 순서대로 찍는순서 배열을 만든 후 검사하기
        */
        final int[][] jjicgi = {{},
                        {1,2,3,4,5}, 
                        {2,1,2,3,2,4,2,5},
                        {3,3,1,1,2,2,4,4,5,5}};
        int[] correct = new int[4];
        for(int i = 0; i < answers.length; i++){
            // 1번
            if(answers[i] == jjicgi[1][i%jjicgi[1].length])
                correct[1]++;
            // 2번
            if(answers[i] == jjicgi[2][i%jjicgi[2].length])
                correct[2]++;
            // 3번
            if(answers[i] == jjicgi[3][i%jjicgi[3].length])
                correct[3]++;
        }
        // 최대값 찾기
        /*
            IntStream을 사용하여 1부터 3까지의 범위를 사용하고, 
            map(i -> correct[i])는 스트림의 각 원소에 대해 주어진 함수를 적용한 결과를 새로운 스트림에 담는다.
            여기서 함수는 i -> correct[i]로, 각 인덱스를 correct 배열의 해당 인덱스 값으로 변환한다.
            즉, 이 연산 후 스트림은 {correct[1], correct[2], correct[3]}을 가진다.
            max()는 스트림에서 최대 값을 찾아 OptionalInt를 반환한다. 
            orElse(0)는 OptionalInt가 비어있지 않으면 최대값을 반환하고, 비어있으면 (스트림이 비어있을 경우) 0을 반환한다.
        */
        // 만약 최대값을 위 반복문 안에서 찾는다면 maxCnt값은 가변되므로 아래 람다식에서 사용하지 못한다. 
        // 람다를 사용할때 변수기준은 final이어야한다는데 반복문안에서는 값이 변동돼서 안된다나..? 이건 좀 찾아봐야겠다.
        // 그래서 따로 밖으로 꺼내 최대값을 찾는 방법을 사용해야한다.
        int maxCnt = IntStream.range(1, 4).map(i -> correct[i]).max().orElse(0);
        /*
            IntStream을 사용하여 1부터 3까지의 범위를 사용하고, 
            correct 배열의 값이 maxCnt와 같은 인덱스를 필터링한 다음 
            answer 배열에 저장
        */
        answer = IntStream.range(1,4)
            .filter(i -> correct[i] == maxCnt)
            .toArray();
        return answer;
    }
}