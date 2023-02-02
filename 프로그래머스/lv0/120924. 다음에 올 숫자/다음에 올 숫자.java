class Solution {
    public int solution(int[] common) {
        int answer = 0;
        // 차가 같으면 등차수열
        if(common[1]-common[0] == common[2]-common[1]){
            System.out.println("등차수열");
            return common[common.length-1]+common[1]-common[0];
        }
        // 다르니 등비수열
        else{
            System.out.println("등비수열");
            return common[common.length-1] * common[1]/common[0];
        }
    }
}