import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            System.out.println(calculateMonkeys(reader.readLine()));
        }
    }

    private static int calculateMonkeys(String input) {
        int depth = 0;
        int maxDepth = 0;

        for (char c : input.toCharArray()) {
            if (c == '[') {
                depth++;
            } else {
                depth--;
            }
            maxDepth = Math.max(maxDepth, depth);  // 최대 깊이를 추적
        }

        return (int) Math.pow(2, maxDepth);  // 원숭이의 수 = 2^최대깊이
    }
}