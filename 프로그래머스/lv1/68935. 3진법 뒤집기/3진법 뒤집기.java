class Solution {
    public int solution(int n) {
        int answer = 0;
        // 정수 n을 3진법의 문자열로 변환
        String s = Integer.toString(n, 3);
        String reversed = new StringBuilder(s).reverse().toString();
        // 다시 3진법의 정수로 변환하여 반환.
        return Integer.valueOf(reversed, 3);
    }
}