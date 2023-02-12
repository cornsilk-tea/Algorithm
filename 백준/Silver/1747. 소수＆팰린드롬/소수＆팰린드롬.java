import java.util.Scanner;

/*********************************************************************
 *Title : 소수&amp;팰린드롬
 *Description : 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다.
 * 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때,
 * N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.
 *Input : 첫째 줄에 N이 주어진다.
 *Output : 첫째 줄에 조건을 만족하는 수를 출력한다.
 *********************************************************************/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] table = new int[10000001];
        for (int i = 2; i < table.length; i++) {
            table[i] = i;
        }
        for (int i = 2; i < table.length; i++) {
            if(table[i] == 0) continue;;
            for (int j = i+i; j < table.length; j+=i) {
                table[j] = 0;
            }
        }
        int answer = 0;
        for (int i = N; i < table.length; i++) {
            if(table[i] != 0){
                boolean check = isPalindrome(i);
                if(check){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static boolean isPalindrome(int i) {
        String s = i+"";
//        System.out.println(s);
        boolean check = true;
        for (int j = 0; j <= s.length()/2; j++) {
            if(s.charAt(j) != s.charAt(s.length()-1-j)){
                check = false;
                break;
            }
        }
        return check;
    }
}