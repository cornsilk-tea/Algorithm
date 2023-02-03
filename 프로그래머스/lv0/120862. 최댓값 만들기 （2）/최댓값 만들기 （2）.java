class Solution {
    public int solution(int[] numbers) {
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i++){
            for(int j = i; j < numbers.length; j++){
                if(i!=j)
                answer = Math.max(answer, numbers[i]*numbers[j]);
            }
        }
        return answer;
    }
}