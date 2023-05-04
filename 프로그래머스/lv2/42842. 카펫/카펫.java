import java.util.*;
/*
    노란색으로 만들 수 있는 사각형의 형태를 모두 찾은 뒤
    그 둘레에 갈색카펫의 수가 매칭이 되는지 확인한다.
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int r = yellow; r >0; r--){
            if(yellow%r != 0)
                continue;
            // r을 기준으로 c계산
            int c = yellow/r;
            // 첫 사각형의 r,c를 기준으로 그 다음 둘레 사각형이 몇개오는지 식을 찾는다.
            // 다음둘레 = r*2 + c*2+4;
            // 주의 : 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다.
            // 해당 식을 기준으로 재귀한다.
            int[] tempAnswer = calc(brown, r, c);
            // 0,1인덱스가 0이 아니라면 찾은것이다.
            if(tempAnswer[0] != 0 && tempAnswer[1] != 0){
                answer = tempAnswer;
                break;
            }
        }
        answer[0] = answer[0]+2;
        answer[1] = answer[1]+2;
        return answer;
    }
    private int[] calc(int brown, int r, int c){
        // 현재 r,c를 기준으로 하는 사각형의 둘레의 값을 구해준다.
        int currCalc = r*2 + c*2+4;
        // 종료조건(점화식 계산 결과가 brown과 일치하거나, brown의 크기를 넘어간다면)
        if(currCalc >= brown){
            if(currCalc == brown){
                return new int[]{r,c};
            }
            else
                return new int[2];
        }
        // 현재 둘레의 다음 둘레를 계산한다.
        return calc(brown, r+2, c+2);
    }
}