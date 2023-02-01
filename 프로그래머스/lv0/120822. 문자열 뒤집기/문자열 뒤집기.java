class Solution {
    public String solution(String my_string) {
        char[] strArr = my_string.toCharArray();
        String answer = "";
        for(int i = 0; i < strArr.length; i++){
            answer += strArr[strArr.length-i-1];
        }
        return answer;
    }
}