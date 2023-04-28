class Solution {
    public int[] solution(String s) {
        // 이진변환의 횟수 = answer[0], 제거된 모든 0의 개수 = answer[1]
        int[] answer = new int[2];
        int zeroCnt = 0;
        while(s.length() > 1){
            // x의 모든 0을 제거합니다.
            // x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
            answer[0]++;
            // s에서 0의 개수를 카운트
            for(int i = 0; i < s.length(); i++){
                if(s.substring(i, i+1).equals("0")){
                    // 0발견
                    zeroCnt++;
                }
            }
            // s에 s.length()-zeroCnt의 2진법을 문자열로 변환하여 저장한다.
            s = Integer.toString(s.length()-zeroCnt, 2);
            answer[1]+=zeroCnt;
            zeroCnt = 0;
        }
        return answer;
    }
}