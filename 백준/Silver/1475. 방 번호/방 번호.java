import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[10];
        String roomNum = br.readLine();
        for(int i=0; i<roomNum.length(); i++) {
            count[roomNum.charAt(i) - '0']++;
        }
        int set = 0;
        for(int i=0; i<10; i++) {
            if(i != 6 && i != 9) {
                set = Math.max(set, count[i]);
            }
        }
        set = Math.max(set, (count[6] + count[9] + 1) / 2);
        System.out.println(set);
    }
}
