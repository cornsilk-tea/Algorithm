import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arrA = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] arrD = {8, 7, 6, 5, 4, 3, 2, 1};
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] input = new int[8];
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }
    if (Arrays.equals(input, arrA)) {
      System.out.println("ascending");
    } else if (Arrays.equals(input, arrD)) {
      System.out.println("descending");
    } else {
      System.out.println("mixed");
    }
  }
}