import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String word = "";
        int answer = 0;
        for(int t = 0; t < T; t++){
            answer = 0;
            word = br.readLine();
            int s = 0, e = word.length()-1;
            while(s < e){
                if(word.charAt(s) != word.charAt(e)){
                    if(isPalindrome(word, s, e-1) | isPalindrome(word, s+1, e)){
                        answer = 1;
                    }
                    else {
                        answer = 2;
                    }
                    break;
                }
                s++;
                e--;
            }
            // 문자열 그 자체로 회문이면 0, 유사회문이면 1, 그 외는 2를 출력
            System.out.println(answer);
        }
    }


    private static boolean isPalindrome(String word, int s, int e) {
        while(s < e){
            if(word.charAt(s) != word.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}