class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        System.out.println("first "+box[0]/n);
        System.out.println("second "+box[1]/n);
        System.out.println("third "+box[2]/n);
        return (box[0]/n)*(box[2]/n)*(box[1]/n);
    }
}