import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(r(br.readLine(), br.readLine()) ? 1 : 0);
    }

    private static boolean r(String s, String t) {
        return t.length() <= s.length() ? t.equals(s) : ((t.charAt(t.length()-1) == 'A' && r(s, t.substring(0, t.length()-1))) ||
                (t.charAt(0) == 'B' && r(s, new StringBuilder(t.substring(1)).reverse().toString())));
    }
}