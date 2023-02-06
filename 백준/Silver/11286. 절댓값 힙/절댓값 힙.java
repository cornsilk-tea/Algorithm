import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] table = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int a1 = Math.abs(a);
            int b1 = Math.abs(b);
            if(a1 == b1){
                return a > b ? 1 : -1;
            }
            else{
                return a1 - b1;
            }
        });
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if(x != 0) pq.add(x);
            else{
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.remove());
            }
        }
    }
}