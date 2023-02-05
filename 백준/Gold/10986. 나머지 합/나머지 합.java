import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line[i]) % m;
        }

        long result = 0;
        int[] count = new int[m];
        count[0] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % m;
            result += count[sum];
            count[sum]++;
        }

        System.out.println(result);
    }
}