import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] table = new int[N];
        for (int i = 0; i < N; i++) {
            table[i] = sc.nextInt();
        }
        // 버블정렬 시작
        for (int i = N-1; i >= 1; i--) {
            int swapCnt = 0;
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if(table[j] > table[j+1]){
                    temp = table[j+1];
                    table[j+1] = table[j];
                    table[j] = temp;
                }
            }
        }
        for(int i : table){
            System.out.println(i);
        }
    }
}