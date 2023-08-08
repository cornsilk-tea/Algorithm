import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K, result;
    // 기본적으로 알아야 하는 글자들
    static final String baseAlphabetes = "antic";
    static final int baseWordBit = 535741;
    // 입력 받은 단어들(비트마스킹을 위해 int 사용)
    static int[] words;
    static int[] alphabetCount;
    static List<Character> usedAlphabets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 모든 단어 앞 뒤에 들어가는 anta, tica에 해당하는 글자들의 집합인 baseAlphabete
        // 이보다 적은 수의 K개가 들어오면 기본 단어들도 읽을 수 없기 때문에 무조건 0이다.
        if (K < baseAlphabetes.length()) {
            System.out.println("0");
            return;
        }
        // 전체 알파벳을 알면 모든 단어를 읽을 수 있다.
        if (K == 26) {
            System.out.println(N);
            return;
        }
        words = new int[N];
        usedAlphabets = new ArrayList<>();
        String inputWord = "";
        for (int i = 0; i < N; i++) {
            inputWord = br.readLine();
            // 기본으로 들어가는 글자들인 anta, tica를 제거한 나머지 문자를 저장한다.
            inputWord = inputWord.substring(4, inputWord.length() - 4);
            // 입력된 데이터로 비트마스킹 한 값을 저장.
            for (char c : inputWord.toCharArray()) {
                if(!isBaseAlphabet(c)){
                    words[i] |= makeChatToBit(c);
                    if (!usedAlphabets.contains(c)) {
                        usedAlphabets.add(c);
                    }
                }
            }
        }
        if (usedAlphabets.size() < K-5) {
            System.out.println(N);
            return;
        }
        result = 0;
//        System.out.println(Arrays.toString(words));
        dfs(0, 0, 0);
        System.out.println(result);
    }
    private static void dfs(int index, int cnt, int selected){
        // 종료조건
        if(cnt == K-5){
            int readableWords = 0;
            for(int word : words){
                if((selected & word) == word){
                    readableWords++;
                }
            }
            result = Math.max(result, readableWords);
            return;
        }
        if(index == usedAlphabets.size())
            return;
        // 본문
        dfs(index + 1, cnt, selected);
        dfs(index + 1, cnt + 1, selected | (1 << usedAlphabets.get(index) - 'a'));
    }
    private static boolean isBaseAlphabet(char c){
        return baseAlphabetes.indexOf(c) >= 0;
    }
    private static int makeChatToBit(char c){
        return 1 << (c - 'a');
    }
}