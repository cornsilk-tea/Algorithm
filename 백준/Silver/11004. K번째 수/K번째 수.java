import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 퀵정렬
//        quickSort(arr, 0, N-1);
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[K-1]);
    }


    private static void quickSort(int[] arr, int start, int end) {
        // 배열이 null이거나 길이가 0일경우 리턴
        if(arr == null || arr.length == 0) return;
        // start가 end보다 크거나 같으면 리턴
        if(start >= end) return;

        // 피벗을 선택
        int mid = start + (end - start)/2;
        int pivot = arr[mid];

        int i = start, j = end;
        // 피벗을 기준으로 정렬
        while(i <= j){
            // i가 피벗보다 작은 값을 찾을 때까지 증가
            while(arr[i] < pivot){
                i++;
            }
            // j가 피벗보다 큰 값을 찾을때까지 감소
            while(arr[j] > pivot){
                j--;
            }
            // i가 j보다 작거나 같으면 swap
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j] ;
                arr[j] = temp;
                i++;
                j--;
            }
            // 하위 배열 분할 후 재귀적으로 정렬
            if(start < j){
                quickSort(arr, start, j);
            }
            if(end > i){
                quickSort(arr, i, end);
            }

        }

    }
}