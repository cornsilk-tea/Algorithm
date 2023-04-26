class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            builder.append(move(c, n));
        }
        return builder.toString();
    }
    private char move(char c, int n){
        if (c >= 'A' && c <= 'Z') {
            return (char) ((c - 'A' + n) % 26 + 'A');
        } 
        else if (c >= 'a' && c <= 'z') {
            return (char) ((c - 'a' + n) % 26 + 'a');
        } 
        else {
            return c;
        }
    }
}