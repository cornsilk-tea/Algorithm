import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        // 홀수일때
        if(num%2 != 0){
            // total/num를 한 후 앞뒤로 num/2만큼더해주면 됨
            int halfTotal = total/num;
            int halfNum = num/2;
            System.out.println(halfTotal);
            System.out.println(halfNum);
            answer[halfNum] = halfTotal;
            for(int i = 1; i <= halfNum; i++){
                answer[halfNum-i] = halfTotal-i;
                answer[halfNum+i] = halfTotal+i;
            }
        }
        // 짝수일때
        else{
            // total/num를 한 후 앞뒤로 num/2와 num/2-1만큼더해주면 됨
            // 즉 두번의 계산이 필요하다.
            int halfTotal = total/num;
            int halfNum = num/2;
            System.out.println(halfTotal);
            System.out.println(halfNum);
            // 중간수를 구한 후 num/2만큼 양쪽으로 더해주다가 한 수가 남았을떄
            // 그 수가 작은쪽 수인지 큰쪽 수인지 판단해서 마지막에 넣어주면 된다.
            int calc = halfTotal;
            List<Integer> list = new ArrayList<Integer>();
            list.add(halfTotal);
            for(int i = 1; i <= halfNum; i++){
                System.out.println("더할 양쪽값은 = "+(halfTotal-i)+", "+(halfTotal+i));
                // 반복문의 마지막 판단
                if(i == halfNum){
                    // 두 수중 하나만 선택
                    list.add(total-calc);
                    break;
                }
                list.add(halfTotal-i);
                list.add(halfTotal+i);
                calc += halfTotal * 2 ;
                System.out.println("calc = "+calc);
            }
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}