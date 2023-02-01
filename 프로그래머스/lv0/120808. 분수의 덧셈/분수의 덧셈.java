class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int bunja = numer1*denom2+numer2*denom1;
        int bunmo = denom1*denom2;
        System.out.println(bunja +" "+ bunmo);
        int gcd = getGcd(Math.max(bunja, bunmo), Math.min(bunja, bunmo));
        System.out.println(gcd);
        answer[0] = bunja/gcd;
        answer[1] = bunmo/gcd;
        return answer;
    }
    static int getGcd(int a, int b){
	if (a%b == 0) {
		return b;
	}
	return getGcd(b, a % b);
}
}