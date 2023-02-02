class Solution {
    static int[] dr = {0,1,1,1,0,-1,-1,-1};
    static int[] dc = {-1,-1,0,1,1,1,0,-1};
    static int n;
    public int[][] makeDanger(int r, int c, int[][] board){
        for(int i = 0; i < 8; i++){
            int nr = r+dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
            if(board[nr][nc] == 0){
                board[nr][nc] = 2;
            }
        }
        return board;
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                if(board[r][c] == 1){
                    // 이때 8방탐색 해야함
                    board = makeDanger(r,c, board);
                }
            }
        }
        // 다 돌고나서 전체 배열 출력해보자
        for(int[] a : board){
            for(int b : a){
                System.out.print(b+" ");
                if(b == 0) answer++;
            }
            System.out.println();
        }
        return answer;
    }
}