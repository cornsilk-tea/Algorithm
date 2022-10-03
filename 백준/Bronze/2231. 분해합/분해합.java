import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    boolean check = false;
    for (int i = 1; i < N; i++) {
      int val = i;
      int sum = i;
      while (val != 0) {
        sum += val % 10;
        val /= 10;
      }
      if (sum == N) {
        check = true;
        System.out.println(i);
        break;
      }
    }
    if (check == false)
      System.out.println(0);
  }

}