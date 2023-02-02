import java.util.*;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int answer = 0;
        // 배열이 한자리면 그냥 이러고 끝내면 됨
        if(array.length == 1) return array[0];
        
        // 시작
        int[] table = new int[array[array.length-1]+1];
        // array배열의 첫번째 값을 고정적으로 넣어준다.
        int maxCnt = 0;
        int maxNumber = array[0];
        int pastMaxCnt = 1;
        int pastNumber = array[0];
        table[pastNumber]++;
        for(int i = 1; i < array.length; i++){
            // 여기서 최대값을 한번 찾아줄 필요가 있다.
            // 만약 지금 받은 숫자가 이전 숫자와 다르다면
            if(array[i] != pastNumber || i == array.length-1){
                // pastMaxCnt와 maxCnt를 비교해서 값이 더 크거나 같은지 확인(최빈값이 여러개면 그중 큰수를 가지기 위함)
                if(pastMaxCnt >= maxCnt){
                    // 현재 pastMaxCnt값이 현재 maxCnt값보다 더 크므로 갱신해준다.
                    maxCnt = pastMaxCnt;
                    // 숫자도 해당 숫자로 변경해준다.
                    maxNumber = pastNumber;
                }
                System.out.println("maxNumber = " + maxNumber);
                System.out.println("maxCnt = " + maxCnt);
                // 값이 더 크지 않다면 past들을 초기화해주고 그냥 넘어간다.
                pastMaxCnt = 1;
                pastNumber = array[i];
            }
            // 배열에 해당하는 숫자의 자리의 값을 +1해준다.
            table[array[i]]++;
            pastMaxCnt++;
        }
        System.out.println(Arrays.toString(table));
        // 위 과정을 거치면 단순히 i번째 배열에 숫자 i의 개수가 들어간다.
        
        // 카운트를 비교하기 위해 임시값 저장;
        int cnt = -1;
        System.out.println("after finish");
        System.out.println("maxNumber = " + maxNumber);
        System.out.println("maxCnt = " + maxCnt);
        for(int i = 0; i < table.length; i++){
            // 값이 0이면 숫자 i는 카운트되지 않음
            if(table[i] == 0) continue;
            if(table[i] > cnt){
                // answer에 i를 저장하고 cnt를 갱신해줌
                answer = i;
                cnt = table[i];
            }
            else if(table[i] == cnt){
                // 기존에 저장되어있던 maxNumber와 같지 않음에도 카운트가 같다면 최빈값 여러개임
                if(maxNumber == i) return -1;
            }
            
        }
        
        return answer;
    }
}