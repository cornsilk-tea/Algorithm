import java.util.*;
class Solution {
    static final String[] alphabet = {"A","E","I","O","U"};
    public int solution(String word) {
        // alphabet안에 들어있는 문자열을 기준으로 만들 수 있는 모든 단어를 만들어 dict에 저장
        List<String> dict = makeString("");
        // 사전순으로 모든 문자열이 저장되어있는 dict의 word 위치를 찾으면 그게 답
        int answer = dict.indexOf(word);
        return answer;
    }
    // 모든 문자열을 찾아서 리스트로 저장하는 함수
    /*
        1.  makeString("")에서 "A"를 추가하여 makeString("A") 호출
        2.  makeString("A")에서 "A"를 추가하여 makeString("AA") 호출
        3.  이 과정을 반복하여 makeString("AAAAA") 호출
        4.  makeString("AAAAA")의 종료 조건이 충족되므로 ["AAAAA"]를 반환
        5.  makeString("AAAA")로 돌아와 for(String s : alphabet)절에서 다음 알파벳인 "E"를 추가하여 makeString("AAAE") 호출
        6.  이 과정을 반복하여 
            makeString("AAAEA"), makeString("AAAEI"), makeString("AAAEIO"), makeString("AAAEIU")
            를 호출하고 각각 반환된 문자열 리스트를 합칩니다. 
            결과로 makeString("AAAA")에서는 ["AAAAA", "AAAE", "AAAEA", "AAAEI", "AAAEIO", "AAAEIU"]를 반환
        7.  이러한 과정을 계속 반복하여 makeString("")로 돌아온다
            여기서 "A"에 대한 모든 문자열을 생성하고 "E"를 추가하여 makeString("E")를 호출
    */
    private List<String> makeString(String newWord){
        // 재귀로 들어가며 현재 생성된 문자열을 저장할 리스트를 만들기
        List<String> words = new ArrayList<>();
        // 생성된 리스트에 현재 생성된 문자열 저장
        words.add(newWord);
        // 종료조건(문자열의 크기가 5가 될 경우 종료하며 지금까지 생성된 사전순의 리스트값을 반환)
        if(newWord.length() == 5){
            return words;
        }
        // alphabet에 들어있는 문자들을 하나씩 newWord뒤에 추가하며 재귀돌리기
        for(String s : alphabet){
            // 해당 재귀들을 통해 생성되며 합쳐지는 문자열들을 words에 모두 합치기 위해 addAll 사용
            words.addAll(makeString(newWord+s));
        }
        // 최종적으로 생성된 모든 words를 반환
        return words;
    }
}