import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터의 정렬 전 index와 정렬 후 index를 비교해
        // 왼쪽으로 가장 많이 이동한 값 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data[] nTable = new Data[N];
        for (int i = 0; i < N; i++) {
            nTable[i] = new Data(i,Integer.parseInt(br.readLine()));
        }
        Arrays.sort(nTable);
        int max = 0;
        for (int i = 0; i < N; i++) {
            if(max < nTable[i].index-i){
                max = nTable[i].index-i;
            }
        }
//        System.out.println(Arrays.toString(nTable).replaceAll("[\\]\\[,]",""));
        System.out.println(max+1);
    }
    static class Data implements Comparable<Data> {
        int index;
        int value;
        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}