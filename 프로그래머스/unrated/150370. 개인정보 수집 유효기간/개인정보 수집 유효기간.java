import java.util.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        HashMap<String, Integer> termMap = new HashMap();
        StringTokenizer st;
        for(String term : terms){
            st = new StringTokenizer(term);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        int[] todayArr = new int[3];
        int[] tempDateArr = new int[3];
        st = new StringTokenizer(today,".");
        // 일로 계산을 하자.
        int todayTotalDay = 0;
        for(int i = 0; i < 3; i++){
            todayArr[i] = Integer.parseInt(st.nextToken());
        }
        todayTotalDay = todayArr[0]*12*28 + todayArr[1]*28+todayArr[2];
        System.out.println(todayTotalDay);
        List<Integer> result = new ArrayList<>();
        for(int p = 0; p < privacies.length; p++){
            st = new StringTokenizer(privacies[p]);
            String date = st.nextToken();
            String term = st.nextToken();
            st = new StringTokenizer(date,".");
            tempDateArr = new int[3];
            for(int i = 0; i < 3; i++){
                tempDateArr[i] = Integer.parseInt(st.nextToken());
            }
            int tempDateTotalDay = tempDateArr[0]*12*28 + tempDateArr[1]*28+tempDateArr[2];
            // 날짜계산
            tempDateTotalDay += termMap.get(term)*28-1;
            System.out.println(tempDateTotalDay);
            if(tempDateTotalDay < todayTotalDay){
                result.add(p+1);
            }
            System.out.println(result);
        }        
        return result;
    }
}