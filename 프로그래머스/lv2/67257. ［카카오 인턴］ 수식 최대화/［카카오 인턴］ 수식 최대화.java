import java.util.*;

class Solution {
    static long max;
    static String[] std = {"+", "-", "*"};
    
    public long solution(String expression) {
        max = 0;
        // 특정 구분자를 기반으로 문자열 나누기
        StringTokenizer st = new StringTokenizer(expression, "+|-|*", true);
        List<String> tokens = new ArrayList<String>();
        while(st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }
        permutation(tokens, new ArrayList<Integer>(), new boolean[3]);
        return max;
    }
    
    // 연산자 우선순위를 구하고, 각 경우에 대해 계산을 수행하는 함수
    private void permutation(List<String> tokens, List<Integer> stdList, boolean[] visited){
        if(stdList.size() == 3){
            // 수식 계산 하기
            long currResult = calc(tokens, stdList);
            max = Math.max(max, currResult);
            return;
        }
        // 재귀를 통해 연산자 우선순위 구하기
        for(int i = 0; i < 3; i++){
            if(!visited[i]){
                visited[i] = true;
                stdList.add(i);
                permutation(tokens, stdList, visited);
                visited[i] = false;
                stdList.remove(stdList.indexOf(i));
            }
        }
    }
    
    // 주어진 연산자 우선순위에 따라 수식을 계산하는 함수
    private long calc(List<String> tokens, List<Integer> stdList){
        // 원본 tokens를 보존하기 위해 복사본 생성
        List<String> localTokens = new ArrayList<>(tokens);
        
        // 연산자 우선순위에 따라 계산 진행
        for(int op = 0; op < 3; op++){
            String currOp = std[stdList.get(op)];
            for(int n = 0; n < localTokens.size(); n++){
                if(localTokens.get(n).equals(currOp)){
                    long firstNum = Long.parseLong(localTokens.get(n-1));
                    long secondNum = Long.parseLong(localTokens.get(n+1));
                    Long tempResult = switch(currOp){
                            case "+" -> firstNum + secondNum;
                            case "-" -> firstNum - secondNum;
                            case "*" -> firstNum * secondNum;
                            default -> 0L;
                    };
                    localTokens.set(n-1, tempResult+"");
                    localTokens.remove(n);
                    localTokens.remove(n);
                    n--; // 연산자가 삭제되었으므로 인덱스를 하나 줄여준다.
                }
            }
        }
        return Math.abs(Long.parseLong(localTokens.get(0)));
    }
}
