class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0 ; i < babbling.length; i++){
            String bab = babbling[i];
            System.out.println("-----------------------");

            if(babbling[i].length() > 10 || babbling[i].length()<2) continue;
            if(bab.contains("aya")){
               bab =  bab.replace("aya",".");
                System.out.println(bab);
            }
            if(bab.contains("ye")){
                bab = bab.replace("ye",".");
                System.out.println(bab);
            }
            if(bab.contains("woo")){
               bab =  bab.replace("woo",".");
                System.out.println(bab);
            }

            if(bab.contains("ma")){
              bab =   bab.replace("ma",".");
                System.out.println(bab);
            }
            bab = bab.replace(".","");
            System.out.println("최종 "+bab.length());
            
            if(bab.length()==0) answer++;
        }
        
        return answer;
    }
}