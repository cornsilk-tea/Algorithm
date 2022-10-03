import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String temp = br.readLine();
      boolean check = false;
      int input = Integer.parseInt(temp);
      if (input == 0) {
        break;
      } else if (input < 10) {
        check = true;
      }
      char[] arr = temp.toCharArray();
      for (int i = 0; i < arr.length / 2; i++) {
        if (arr[i] == arr[arr.length-1 - i]) {
          check = true;
        } else {
          check = false;
          break;
        }
      }
      if (check)
        System.out.println("yes");
      else
        System.out.println("no");
    }
  }

}