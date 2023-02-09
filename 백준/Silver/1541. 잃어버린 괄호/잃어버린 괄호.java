import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "[-]");
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        int answer = 0;
        int temp = 0;
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            temp = 0;
            if(list.get(i).contains("+")){
                st = new StringTokenizer(list.get(i), "+");
                while(st.hasMoreTokens()){
                    temp+= Integer.parseInt(st.nextToken());
                }
                if(i == 0){
                    // answer에 더해줘야함
                    answer += temp;
                }
                else{
                    answer -= temp;
                }
            }
            else if(i == 0){
                // 숫자만 있음
                answer += Integer.parseInt(list.get(i));
            }
            else{
                answer -= Integer.parseInt(list.get(i));

            }
        }

        System.out.println(answer);
    }
}