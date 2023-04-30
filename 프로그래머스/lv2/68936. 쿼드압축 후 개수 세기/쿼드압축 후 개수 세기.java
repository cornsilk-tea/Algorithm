class Solution {
    public static int[] result;
    public int[] solution(int[][] arr) {
        result = new int[2];
        quard(arr, 0, 0, arr.length);
        return result;
    }
    
    private void quard(int[][] arr, int rPoint, int cPoint, int size){
        // 종료조건(현재 2차원 배열을 전체탐색해서 한가지의 숫자만 있는게 확인되면 멈춤)
        int stdNum = 0;
        boolean check = true;
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                if(r == 0 && c == 0){
                    stdNum = arr[rPoint+r][cPoint+c];
                    continue;
                }
                if(arr[rPoint+r][cPoint+c] != stdNum){
                    check = false;
                    break;
                }
            }
            if(check == false){
                break;
            }
        }
        // 현재 선택된 범위에서 한가지의 수만 발견됨
        if(check == true){
            result[stdNum]++;
            return;
        }
        // 재귀 들어가기(4번이 들어가야함)
        quard(arr, rPoint, cPoint, size/2);
        quard(arr, rPoint + size/2, cPoint, size/2);
        quard(arr, rPoint, cPoint + size/2, size/2);
        quard(arr, rPoint + size/2, cPoint + size/2, size/2);
        
    }
}