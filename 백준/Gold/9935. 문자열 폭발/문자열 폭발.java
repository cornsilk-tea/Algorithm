import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다
        char[] word = br.readLine().toCharArray();
        // 길이는 1보다 크거나 같고, 36보다 작거나 같다.
        char[] boom = br.readLine().toCharArray();
        // word가 순차적으로 들어갈 stack
        Stack<Character> stack = new Stack<>();
        // 임시로 비교할 데이터를 저장할 stack
        Stack<Character> tempStack = new Stack<>();
        // word의 문자를 순차적으로 stack안에 넣으며
        // boom의 끝 문자가 나올때를 기다린다.
        for(int i = 0; i < word.length; i++){
            char curr = word[i];
            // 현재 stack에 넣어야 하는 문자가 boom의 마지막 문자와 같다면?
            if(curr == boom[boom.length-1]){
                if(stack.size() < boom.length-1){
                    stack.push(curr);
                }
                else{
                    // 탐색작업 시작
                    // tempStack에 데이터를 순차저장한다.
                    tempStack.push(curr);
                    // boom의 맨 뒷자리는 이미 비교했으니, 뒤에서 두번째자리부터 비교한다.
                    for(int j = boom.length-2; j >= 0; j--){
                        // 여기서 stack.pop()했을때 EmptyStack에러가 난다. 에러처리를 해주자.
                        if(stack.isEmpty()){
                            stack.push(tempStack.pop());
                            break;
                        }
                        // stack이 비지 않았다면, 정상진행
                        char tempCurr = stack.pop();
                        // 같다면?
                        if(tempCurr == boom[j]){
                            tempStack.push(tempCurr);
                        }
                        // 다르다면? 즉시 멈추고, tempStack안에 있는 값들을 모두 stack안에 넣어준다.
                        else{
                            // 우선 방금 stack에서 pop한 tempCurr부터 stack안에 다시 넣어주고
                            stack.push(tempCurr);
                            // tempStack안에 있던 애들을 stack안에 다시 넣어준다.
                            while(!tempStack.isEmpty()){
                                stack.push(tempStack.pop());
                            }
                            // boom을 할 수 없으니 멈춰준다.
                            break;
                        }
                    }
                    // tempStack을 비어준다.
                    tempStack.clear();
                }
            }
            else{
                stack.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");

    }
}