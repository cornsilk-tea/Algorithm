import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        List<Double> list = new ArrayList<>();
        for(int[] a : score){
            Double temp = ((double)a[0]+(double)a[1])/2;
            list.add(temp);
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        for(int i = 0; i < score.length; i++){
            answer[i] = list.indexOf(((double)score[i][0]+(double)score[i][1])/2)+1;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}