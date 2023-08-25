import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    /*
    주사위 대응
    0 - 5
    1 - 3
    2 - 4
 */
    static int[] diceFaceRelation = {5,3,4,1,2,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] diceArr = new int[N][6];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++){
                diceArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int[] a : diceArr){
//            System.out.println(Arrays.toString(a));
//        }

        // 한 주사위의 기준면을 0, 1, 2 세번만 잡으면 계산 완료.
        int resultDiceValuesSum = 0; // 최종 결과값
        for(int face = 0; face < 6; face++){ // face는 현재 기둥 가장 아래 주사위의 면
            int tempResultDiceValuesSum = 0; // 임시 주사위 옆면 합산값
//            System.out.println("case " + face);
            // 첫번째 주사위 기준으로 옆면의 최대값을 tempResultDiceValuesSum에 갱신
//            System.out.println("0번째 주사위 아래면 "+face+", 값 = "+diceArr[0][face]);
            tempResultDiceValuesSum += findMaxDiceFaceValue(diceArr[0], face);
            int diceUpside = diceFaceRelation[face];
//            System.out.println("0번째 주사위 윗면 "+diceUpside+", 값 = "+diceArr[0][diceUpside]);
            // 두번째 주사위부터 끝 주사위까지 모든 옆면값을 계산해서 최종값 반환
            for(int diceN = 1; diceN < N; diceN++){
                // 이전 주사위의 diceFacingSide을 기준으로 해당 값을 찾고, 현재 주사위의 값과 같은 face를 찾는다.
                int diceDownSide = findMatchingDiceFace(diceArr[diceN-1], diceArr[diceN], diceUpside);
//                System.out.println(diceN+"번째 주사위 아래면 " + diceDownSide+", 값 = "+diceArr[diceN][diceDownSide]);
                tempResultDiceValuesSum += findMaxDiceFaceValue(diceArr[diceN],diceDownSide);
                diceUpside = diceFaceRelation[diceDownSide];
//                System.out.println(diceN+"번째 주사위 윗면 " + diceUpside+", 값 = "+diceArr[diceN][diceUpside]);
            }
            // 최종 계산값 갱신
            resultDiceValuesSum = Math.max(resultDiceValuesSum, tempResultDiceValuesSum);
        }
        System.out.println(resultDiceValuesSum);
    }
    // 주사위 면의 위치값을 기준으로 해당 면을 바당으로 둔 상태의 옆면값 4개중 최대값 반환
    public static int findMaxDiceFaceValue(int[] dice, int nonIncludeFace){
        int max = -1;
        for(int i = 0; i < 6; i++){
            if(i != nonIncludeFace && i != diceFaceRelation[nonIncludeFace]){
                max = Math.max(max, dice[i]);
            }
        }
//        System.out.println("현재 주사위의 옆면 최대값 "+ max);
        return max;
    }

    // 이전주사위, 현재주사위, 이전주사위와 현재주사위가 맞닿은값을 가지고 현재 주사위의 아래면을 구해줌.
    public static int findMatchingDiceFace(int[] pastDice, int[] currDice, int pastFace){
        int pastDiceFaceValue = pastDice[pastFace];
        for(int i = 0; i < 6; i++){
            if(currDice[i] == pastDiceFaceValue){
                return i;
            }
        }
        return -1;
    }
}