import java.util.*;

class Solution {
    
    // 응시자의 위치를 담을 클래스 생성
    private static class Point{
        public final int r,c;
        private Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString(){
            return r+" "+c;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] table = new char[5][5];
        // 모든 응시자에 대해
        // 맨해튼 거리가 1인 곳에 다른 응시자가 있는지 1차 확인
        // 맨해튼 거리가 2인 곳에 다른 응시자가 있는지 2차 확인
        // 이 경우 두가지로 갈린다.
        // 1. 맨해튼 거리가 상하좌우로 2인경우
        //    해당 방향으로 맨해튼거리가 1인 자리에 파티션 X가 있을경우에만 거리두기 지킨것으로 판단.
        // 2. 맨해튼 거리가 대각선으로 2인경우
        //    ex) 우상방향으로 거리두기를 판단해야 할 경우 위와 오른쪽으로 맨해튼거리가 1인 자리에 파티션 X가 있어야만 거리두기를 지킨것으로 판단
        
        // 대기실은 5개가 있으므로 tc를 기준으로 5번 반복해준다.
        for(int tc = 0; tc < 5; tc++){
            // 현재 대기실을 char형태의 맵으로 만들어준다.
            for(int i = 0; i < 5; i++){
                table[i] = places[tc][i].toCharArray();
            }
            // printArr(table);
            
            // 응시자의 위치를 저장할 리스트 생성
            List<Point> points = new ArrayList<Point>();
            
            // 전체 반복문을 돌리면서 응시자 P의 위치를 확인한다.
            for(int r = 0; r < 5; r++){
                for(int c = 0; c < 5; c++){
                    if(table[r][c] == 'P'){
                        points.add(new Point(r,c));
                    }
                }
            }
            // System.out.println(points);
            
            // 위치 배열인 델타스 지정(시계방향)
            int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
            
            // 중간에라도 거리두기 지키지 않은 경우가 발생된다면 flag체크를 통해 확인(false가 true로 바뀌는 순간 체크)
            boolean check = false;
            
            // list에 저장된 응시자들의 위치를 기반으로 탐색을 시작한다.
            for(int i = 0; i < points.size(); i++){
                int r = points.get(i).r;
                int c = points.get(i).c;
                
                // 상하좌우 기준으로 맨해튼 거리가 1,2인 경우 체크(상하좌우 체크)
                for(int d = 0; d < 8; d+=2){
                    // 맨해튼 거리가 1인경우 체크
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    // 확인한 위치가 범위 밖이면 상관없으니 넘기기
                    if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
                        continue;
                    
                    // 응시자가 있다면 flag체크해주고 멈추기
                    if(table[nr][nc] == 'P'){
                        check = true;
                        break;
                    }
                    
                    // 맨해튼 거리가 2인경우 체크
                    int nr2 = r + dr[d]*2;
                    int nc2 = c + dc[d]*2;
                    
                    // 확인한 위치가 범위 밖이면 상관없으니 넘기기
                    if(nr2 < 0 || nc2 < 0 || nr2 >= 5 || nc2 >= 5)
                        continue;
                    
                    // 응시자가 있다면 flag체크해주고 멈추기
                    if(table[nr2][nc2] == 'P'){
                        // 맨해튼 거리가 2이지만 그 전에 파티션 X가 있는지 체크
                        if(table[nr][nc] == 'X')
                            continue;
                        check = true;
                        break;
                    }
                    
                }
                // 맨해튼 거리가 1인 경우에서 거리두기를 지키지 않은 경우가 발견됐다면 break;
                if(check == true){
                    break;
                }
                
                //맨해튼 거리가 2면서 대각인 경우 체크
                for(int d = 1; d < 8; d+=2){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    // 확인한 위치가 범위 밖이면 상관없으니 넘기기
                    if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
                        continue;
                    
                    // 응시자가 있다면?
                    if(table[nr][nc] == 'P'){
                        // 해당 방향으로 파티션이 2개가 있는지 확인하기.
                        int r1 = r + dr[d - 1];
                        int c1 = c + dc[d - 1];
                        int r2, c2;
                        if (d == 7) {
                            r2 = r + dr[0];
                            c2 = c + dc[0];
                        } else {
                            r2 = r + dr[d + 1];
                            c2 = c + dc[d + 1];
                        }
                        if(table[r1][c1] == 'X' & table[r2][c2] == 'X')
                            continue;
                        check = true;
                        break;
                    }
                    
                }
                // 맨해튼 거리가 2면서 대각인 경우에서 거리두기를 지키지 않은 경우가 발견됐다면 break;
                if(check == true){
                    break;
                }
            }
            if(check == true){
                answer[tc] = 0;
            }
            else{
                answer[tc] = 1;
            }
        }
        return answer;
    }
    
    public static void printArr(char[][] arr) {
        for (char[] row : arr) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
