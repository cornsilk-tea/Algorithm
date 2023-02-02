class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        if(A.equals(B)) return 0;
        for(int i = 1; i <= a.length; i++){
            char[] temp = new char[a.length];
            for(int j = 0; j < a.length-1; j++){
                temp[j+1] = a[j];
            }
            temp[0] = a[a.length-1];
            a = temp;
            String tempString = new String(a);
            System.out.println("a = "+ tempString +", b = "+B+", i = "+i);
            if(tempString.equals(B)) return i;
        }
        return -1;
    }
}