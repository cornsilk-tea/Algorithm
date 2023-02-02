class Solution {
    public boolean threeCheck(int num){
        if(num%3 == 0 || (num+"").contains("3")) return true;
        return false;
    }
    public int solution(int n) {
        int answer = 0;
        int plus = 2;
        for(int i = 1; i <= n; i++){
            answer++;
            while(threeCheck(answer)){
                answer++;
            }
            System.out.println("i = "+i+", answer = "+answer);
        }
        return answer;
    }
}