import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int tc = 0; tc < quiz.length; tc++){
            StringTokenizer st = new StringTokenizer(quiz[tc], " ");
            List<String> list = new ArrayList<String>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }
            System.out.println(list);
            int result = Integer.parseInt(list.get(list.size()-1));
            System.out.println(result);
            // 전체 리스트의 개수-2가 몇개인지 알면 전체 계산 횟수를 알 수 있다.
            int calcNum = list.size()-2;
            System.out.println(calcNum);

            int tempResult = Integer.parseInt(list.get(0));
            String giho = "";
            for(int i = 1; i < calcNum; i++){
                // 숫자일 경우
                if(i % 2 == 0){
                    // 계산해준다.
                    switch(giho){
                        case "+":
                            tempResult += Integer.parseInt(list.get(i));
                            break;
                        case "-":
                            tempResult -= Integer.parseInt(list.get(i));
                            break;
                    }
                }
                // 기호일 경우
                else{
                    giho = list.get(i);
                }
            }
            // tempResult와 result를 비교한다.
            answer[tc] = tempResult==result?"O":"X";
        }
        return answer;
    }
}