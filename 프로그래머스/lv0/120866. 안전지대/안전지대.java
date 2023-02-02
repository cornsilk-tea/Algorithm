class Solution {
    static int[] dr = {0,1,1,1,0,-1,-1,-1};
    static int[] dc = {-1,-1,0,1,1,1,0,-1};
    static int n;
    static int[][] table;
    public void makeDanger(int r, int c){
        for(int i = 0; i < 8; i++){
            int nr = r+dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
            if(table[nr][nc] == 0){
                table[nr][nc] = 2;
            }
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        table = board;
        n = table.length;
        for(int r = 0; r < table.length; r++){
            for(int c = 0; c < table.length; c++){
                if(table[r][c] == 1){
                    // 이때 8방탐색 해야함
                    makeDanger(r,c);
                }
            }
        }
        // 다 돌고나서 전체 배열 출력해보자
        for(int[] a : table){
            for(int b : a){
                System.out.print(b+" ");
                if(b == 0) answer++;
            }
            System.out.println();
        }
        return answer;
    }
}