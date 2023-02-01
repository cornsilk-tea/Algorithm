class Solution {
    public int solution(int n) {
        int answer = 0;
        while(true){
            System.out.println(n%10);
            answer += n%10;
            n /= 10;
            System.out.println(n);
            if(n<=1) break;
        }
        return n >= 1? answer+n:answer;
    }
}