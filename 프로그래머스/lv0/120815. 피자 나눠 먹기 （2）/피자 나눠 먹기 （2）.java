class Solution {
    public int solution(int n) {
        int answer = 0;
        int gcd = makeGcd(n, 6);
        System.out.println(gcd);
        return n/gcd;
    }
    public int makeGcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return makeGcd(b, a % b);
}
}