class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // dfs문제
        int score = 0;
        int depth = 0;
        dfs(depth, numbers,target, score);
        answer = count;
        return answer;
    }
    public void dfs(int depth, int[] numbers, int target, int score){
        if(depth == numbers.length){
            if(score == target) count++;
        }
        else{
            dfs(depth+1, numbers, target, score+numbers[depth]);
            dfs(depth+1, numbers, target, score-numbers[depth]);
        }
    }
}