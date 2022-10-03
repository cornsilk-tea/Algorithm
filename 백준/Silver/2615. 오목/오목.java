import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static void print(int[][] table) {
    for (int[] r : table) {
      for (int c : r) {
        System.out.print(c + " ");
      }
      System.out.println();
    }
  }

  // -1,1 0,1 1,1 1,0
  // 오위, 오, 오아래, 아래
  static int[] dr = {-1, 0, 1, 1};
  static int[] dc = {1, 1, 1, 0};
  static int result_r = 0;
  static int result_c = 0;

  static int calc(int[][] table) {// 0,1,2를 리턴해주기 위함
    int dolcnt = 0;// 돌의 갯수를 파악하기 위함
    for (int r = 0; r < table.length; r++) {
      for (int c = 0; c < table.length; c++) {

        if (table[r][c] != 0) {// 1 또는 2면은 여기서부터 사방탐색 시자아아악

          int dolcolor = table[r][c];// 그리도 돌의 색깔을 추후에 비교하기위해
          for (int d = 0; d < 4; d++) {// 4방탐색
            /*
             * 우선 탐색하기로한 방향의 반대가 내 돌이 아니거나 테이블을 벗어나면 본격적인 탐색시작
             */
            dolcnt = 1;// 현재 위치의 돌이 있는걸 확인했으니 카운트 올려준다
            int pr = r + -1 * dr[d];// 현위치 탐색반대방향
            int pc = c + -1 * dc[d];// 현위치 탐색반대방향
//            System.out.println((r) + " " + (c) + " d=" + d);
//            System.out.println("이때 반대방향은 " + (pr) + " " + (pc) + " d=" + d);
            if (pc >= 0 && pc < 19 && pr >= 0 && pr < 19) {// 만약 그 반대방향이 범위 안인데
              if (table[pr][pc] == dolcolor) {//그 반대돌이 기존색과 같다면
                continue;// 이방향 건너뛰기
              }
            }
            // System.out.println((r + 1) + " " + (c + 1) + " d=" + d);
            // System.out.println("이때 반대방향은 " + (r + 1) + " " + (c + 1) + " d=" + d);
            // 위 조건을 만족한다면 for문으로 방향탐색시작
            for (int dol = 1; dol < 5; dol++) {
              /*
               * dol이 6목인지까지 파악하기위해 기준위치 이후로 4번을 움직인다.
               */
              int nr = r + dr[d] * dol;
              int nc = c + dc[d] * dol;
              if (nc >= 0 && nc < 19 && nr >= 0 && nr < 19) {// 우선 테이블을 벗어나지 않아야하고
                if (table[nr][nc] == dolcolor) {// 그 다음위치가 기준위치와 같은돌이면
                  dolcnt++;// 돌카운트를 늘려주고 계속 진행한다.
                }
              }
            }
            if (dolcnt == 5) {
//              System.out.println(r + " " + c);
              int nr = r + dr[d] * 5;
              int nc = c + dc[d] * 5;
              /*
               * 5목일 조건 뒤에가 벽이거나 뒤에 내 돌과 다른게 있어야한다.
               */
              // if(nc >= 0 && nc < 19 && nr >= 0 && nr < 19)
              if (!(nc >= 0 && nc < 19 && nr >= 0 && nr < 19)) {// 5번이상째의

                result_r = r;
                result_c = c;
                return dolcolor;
              }
              if (table[nr][nc] != dolcolor) {
//                System.out.println((r + 1) + " " + (c + 1));
//                System.out.println((dr[d]) + " " + (dc[d]));
                // System.out.println((nr+1) +" "+ (nc+1));
                result_r = r;
                result_c = c;
                return dolcolor;
              }
            }
          }
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] table = new int[19][19];
    for (int r = 0; r < table.length; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int c = 0; c < table.length; c++) {
        table[r][c] = Integer.parseInt(st.nextToken());
      }
    }
    // 검은 바둑알 1, 흰 바둑알 2,
    // 검정이 이기면 1, 흰이 이기면 2, 이긴넘이 없으면 0
    // 연속된 다섯개의 바둑알 중에서 가장 왼쪽에 있는 바둑알(세로일경우는 가장 위)
    int win = calc(table);
    if (win != 0) {
      System.out.println(win);
      System.out.println((result_r + 1) + " " + (result_c + 1));
    } else {
      System.out.println(win);
    }


  }

}