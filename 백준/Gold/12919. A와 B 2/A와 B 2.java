import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine(), br.readLine()) ? 1 : 0);
    }

    private static boolean solution(String s, String t) {
        if(t.length() == s.length()){
            return t.equals(s);
        }
        // 문자열 뒤에 A가 있다면 A를 빼준다.
        if(t.endsWith("A") && solution(s, t.substring(0, t.length()-1))){
            return true;
        }
        // 문자열 앞에 B가 있다면, 문자열을 뒤집고 맨 뒤의 B를 빼준다.
        if(t.startsWith("B") && solution(s, new StringBuilder(t.substring(1)).reverse().toString())){
            return true;
        }

        return false;
    }

}