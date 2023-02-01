class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String st = my_string.toLowerCase().replaceAll("[qwertyuiopasdfghjklzxcvbnm]","");
        String[] arry = st.split("");
        for(String a : arry){
            answer+=Integer.parseInt(a);
        }
        return answer;
    }
}