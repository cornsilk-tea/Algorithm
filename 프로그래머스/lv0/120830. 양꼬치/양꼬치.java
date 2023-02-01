class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        answer = 12000*n;
        int extra = n/10;
        answer += 2000*(k-extra);
        return answer;
    }
}