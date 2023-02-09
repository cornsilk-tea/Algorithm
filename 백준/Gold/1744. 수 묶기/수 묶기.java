import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();
        int oneCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0)
                zeroCnt++;
            else if(temp == 1)
                oneCnt++;
            else if(temp > 0)
                plusList.add(temp);
            else
                minusList.add(temp);
        }
        // sort
        plusList.sort(Comparator.reverseOrder());
        minusList.sort(Comparator.naturalOrder());
//        System.out.println(plusList);
//        System.out.println(minusList);
        // 덧셈작업 시작
        // plus고 minus고 앞에서부터 짝수번만큼 곱해서 더해준다.
        int answer = 0;
        int cnt = plusList.size()/2 + plusList.size()%2;
//        System.out.println(cnt);
        for (int i = 1; i < plusList.size(); i+=2) {
            answer += plusList.get(i) * plusList.get(i-1);
            cnt--;
        }
//        System.out.println(cnt);
        if(cnt != 0)
            answer += plusList.get(plusList.size()-1);
        answer += oneCnt;
//        System.out.println(answer);
        // minus작업 시작
        cnt = minusList.size()/2 + minusList.size()%2;
        for (int i = 1; i < minusList.size(); i+=2) {
            answer += minusList.get(i) * minusList.get(i-1);
            cnt--;
        }
        if(cnt != 0){
            answer += zeroCnt > 0 ? 0 : minusList.get(minusList.size()-1);
        }
        System.out.println(answer);
    }
}