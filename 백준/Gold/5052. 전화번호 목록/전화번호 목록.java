import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 테스트케이스 개수만큼 반복
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for(int n = 0; n < N; n++){
                list.add(br.readLine());
            }
            Collections.sort(list);

//            System.out.println(Arrays.toString(list.toArray()));
            boolean result = true;
            for(int i = 0; i < list.size()-1; i++){
                if(list.get(i+1).startsWith(list.get(i))){
                    result = false;
                    break;
                }
            }
            System.out.println(result ? "YES" : "NO");
        }
    }
    private static boolean calc(List<String> list, int idx){
        for(int i = 0; i < list.size(); i++){
            if(i == idx) continue;
            if(list.get(i).startsWith(list.get(idx))){
                return false;
            }
        }
        return true;
    }
}