import java.util.*;
class Solution {
    public int[] solution(int n) {
        if(n == 1){
            return new int[]{1};
        }
        int[] answer = {};
        // 2차원 배열에 들어가있다고 생각하고 진행한다. 
        // 모든 값을 다 넣은 후 첫줄부터 0이 아닐때까지 배열에 값을 저장하고, 그 결과값을 반환한다.
        int[][] arr = new int[n][n];
        // 방향을 지정해 줄 필요가 있다.
        // 방향은 3방향이다. 아래, 오른쪽, 왼쪽 위 대각
        // 아래 arr[i+1][j]
        // 오른쪽 arr[i][j+1]
        // 대각 arr[i-1][j-1]
        // 각각의 방향으로 0이 아닐때까지 진행.
        int[][] deltas = {{1,0},{0,1},{-1,-1}};
        
        int num = 1;
        int d = 0;
        int r = 0;
        int c = 0;
        //반복문을 통해 작업한다.
        while(true){
            // System.out.println("현재방향 = " + d + "");
            // 현재 위치에 이미 숫자가 있다면 멈춰주기
            if(arr[r][c] != 0) 
                break;
            
            // 현재 위치 숫자 넣어주기.
            arr[r][c] = num++;
            
            // 현재 방향으로 더 진행 가능한지 체크
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            // System.out.println("nr = "+nr + ", nc = "+nc);
            
            // 다음위치가 맵을 벗어나거나, 이미 값이 들어가있다면 방향을 틀어야한다.
            if(isOutRange(nr,nc,n) || arr[nr][nc] != 0){
                d = (d+1)%3;
                r = r + deltas[d][0];
                c = c + deltas[d][1];
            }
            else{     
                r = nr;
                c = nc;
            }
            // printArr(arr);

        }
        return getResult(num, arr);
    }
    
    // 정답 배열 추출
    private int[] getResult(int num, int[][] arr){
        int[] result = new int[num-1];
        int n = 0;
        for(int[] a : arr){
            for(int b : a){
                if(b != 0){
                    result[n++] = b;
                }
                else
                    break;
            }
        }
        return result;
    }
    
    // 범위 체크 함수(범위를 벗어난다면 true반환)
    private boolean isOutRange(int r, int c, int n){
        if(r < 0 || c < 0 || r >= n || c >= n){
            return true;
        }
        return false;
    }
    
    // arr프린트 함수
    private void printArr(int[][] arr){
        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}