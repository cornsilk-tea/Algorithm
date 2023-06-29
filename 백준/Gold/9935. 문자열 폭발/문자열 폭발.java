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
        StringBuilder sb = new StringBuilder();

        for(char curr : word){
            sb.append(curr);
            if(curr == boom[boom.length-1] && sb.length() >= boom.length){
                boolean isBoom = true;
                for(int j = 0; j < boom.length -1; j++){
                    if(sb.charAt(sb.length() - boom.length + j) != boom[j]){
                        isBoom = false;
                        break;
                    }
                }
                if(isBoom){
                    sb.delete(sb.length() - boom.length, sb.length());
                }
            }
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}