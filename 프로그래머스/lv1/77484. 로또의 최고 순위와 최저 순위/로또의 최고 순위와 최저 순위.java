import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        // 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
        int baseMatchCnt = 0;
        int zeroCnt = 0;
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < lottos.length; j++){
                if(lottos[i] == win_nums[j])
                    baseMatchCnt++;
            }
            if(lottos[i] == 0)
                zeroCnt++;
        }
        System.out.println(baseMatchCnt);
        System.out.println(zeroCnt);
        if(baseMatchCnt == 6){
            return new int[]{1,1};
        }
        else if(zeroCnt == 6){
            return new int[]{1,6};
        }
        else if(baseMatchCnt == 0 && zeroCnt == 0){
            return new int[]{6,6};
        }
        else{
            answer[0] = 7 -  baseMatchCnt - zeroCnt;
            answer[1] = 7 - baseMatchCnt;
        }
        
        return answer;
    }
}