class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int jjak = 0;
        int hol = 0;
        for(int i = 0; i < num_list.length; i++){
            
            if(num_list[i]%2 == 0) jjak +=1;
            else hol += 1;
        }
        answer[0] = jjak;
        answer[1] = hol;
        return answer;
    }
}