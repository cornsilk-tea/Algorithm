class Solution {
    public int solution(int chicken) {
        // 내가 서비스로 먹은 치킨 수
        int answer = 0;
        // 현재 쿠폰 개수
        int coupon = 0;
        if(chicken < 10) return 0;
        while(chicken >= 10){
            // 새로받을수잇는치킨개수
            int newChicken = chicken/10;
            // 남는 쿠폰
            coupon = chicken%10;
            chicken = newChicken + coupon;
            answer += newChicken;
        }
        return answer;
    }
}