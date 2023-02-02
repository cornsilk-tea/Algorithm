import java.util.*;
class Solution {
    public String solution(String polynomial) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(polynomial, " ");
        int xValue = 0;
        int numValue = 0;
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            if(temp.contains("x")){
                System.out.println(temp);
                if(temp.length() == 1) xValue++;
                else{
                    temp = temp.substring(0, temp.length()-1);
                    xValue += Integer.parseInt(temp);
                }
            }
            else if(temp.equals("+")) continue;
            else{
                numValue += Integer.parseInt(temp);
            }
        }
        System.out.println(xValue + "x + " + numValue);
        
        if(numValue == 0){
            System.out.println("1");
            if(xValue == 1){
                answer += "x"; 
            }
            else{
                answer += xValue + "x"; 
            }
            
        }
        else if(xValue == 0){
            System.out.println("2");
            answer += numValue;
        }
        else if(xValue == 1){
            System.out.println("3");
            answer += "x + " + numValue;
        }
        else if(xValue == 0 && numValue == 0){
            System.out.println("4");
            return "0";
        }
        else{
            System.out.println("5");
            answer += xValue + "x + " + numValue;
        }
        return answer;
    }
}