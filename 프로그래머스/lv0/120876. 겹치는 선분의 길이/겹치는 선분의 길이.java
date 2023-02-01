import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] table = new int[201];
        //101 == 0
        // int j=  -100;
        // for(int i = 0; i < table.length; i++){
        //     table[i] = j++;
        // }
        // System.out.println(Arrays.toString(table));
        // System.out.println(table[100]);
        for(int[] a : lines){
            for(int i = a[0]+100; i < a[1]+100; i++){
                table[i]++;
            }
        }
        for(int a : table){
            if(a > 1) answer++;
        }
        System.out.println(Arrays.toString(table));

        return answer;
    }
}