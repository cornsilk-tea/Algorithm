class Solution {
    public int[] solution(long n) {
        String result = "";
        while(n > 0){
            result += n%10;
            n /= 10;
        }
        char[] a = result.toCharArray();
        int[] answer = new int[a.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = Integer.parseInt(a[i]+"");
        }
        return answer;
    }
}