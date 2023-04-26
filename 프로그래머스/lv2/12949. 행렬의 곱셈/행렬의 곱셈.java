class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        // 행렬 곱셈의 결과, 행렬의 크기는 왼쪽행렬의 행 개수와 오른쪽 행렬의 열 개수를 가진다.
        int[][] arr = new int[arr1.length][arr2[0].length];
        
        // 반복문을 통해 각각의 위치에 맞는 값을 넣어준다.
        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[0].length; c++){
                // 반복문을 통한 값 계산
                for(int i = 0; i < arr1[r].length; i++){
                    arr[r][c] += arr1[r][i] * arr2[i][c];
                }
            }
        }
        
        return arr;
    }
}