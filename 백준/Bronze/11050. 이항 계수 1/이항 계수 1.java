import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int factorial_Recursion(int num) {
		if (num <=1 )
			return 1;
		else return num * factorial_Recursion(num - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		n!/k!*(n-k)!
//		bw.write(factorial_Recursion(N) / (factorial_Recursion(K) * factorial_Recursion(N - K)) + "\n");
		System.out.println(factorial_Recursion(N) / (factorial_Recursion(K) * factorial_Recursion(N - K)));
		bw.flush();
		bw.close();
	}

}