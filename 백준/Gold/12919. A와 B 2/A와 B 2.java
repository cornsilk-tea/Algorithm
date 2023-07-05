import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());
        System.out.println(solution(S, T) ? 1 : 0);
    }

    private static boolean solution(StringBuilder s, StringBuilder t) {
        if(t.toString().equals(s.toString())){
            return true;
        }
        // 문자열 뒤에 A가 있다면 A를 빼준다.
        if(t.length() > 0 && t.charAt(t.length()-1) == 'A'){
            t = t.deleteCharAt(t.length()-1);
            if(solution(s, t)){
                return true;
            }
            t = t.append("A");
        }
        // 문자열 앞에 B가 있다면, 문자열을 뒤집고 맨 뒤의 B를 빼준다.
        if(t.length() > 0 && t.charAt(0) == 'B'){
            t = t.reverse().deleteCharAt(t.length()-1);
            if(solution(s, t)){
                return true;
            }
            t = t.append("B").reverse();
        }

        return false;
    }

}