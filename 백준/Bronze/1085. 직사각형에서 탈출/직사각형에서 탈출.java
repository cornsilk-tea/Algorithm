import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[4];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] table = {arr[0],arr[1],arr[2]-arr[0],arr[3]-arr[1]};
    Arrays.sort(table);
    System.out.println(table[0]);
  }

}