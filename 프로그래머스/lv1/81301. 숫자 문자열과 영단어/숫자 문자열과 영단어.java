class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numberToWord = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        // 0 ~ 9까지 10개의 숫자 반복
        for(int i = 0; i < 10; i++){
            s = s.replace(numberToWord[i], i+"");
        }
        return Integer.parseInt(s);
    }
}