import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean SK = false;
		boolean CY = false;
		if(N%2!=0) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}

	}

}