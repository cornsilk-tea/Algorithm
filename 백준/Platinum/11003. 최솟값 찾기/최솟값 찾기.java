import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Node> myDeque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 데이터의 개수
        int N = Integer.parseInt(st.nextToken());
        // 최소값을 구하는 범위
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        myDeque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 새로운 값이 들어올때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while(!myDeque.isEmpty() && myDeque.getLast().value > now){
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(i, now));
//            System.out.println("now = "+now);
//            System.out.println(myDeque);
            // 범위에서 벗어난 값은 덱에서제거
            if(myDeque.getFirst().index <= i-L){
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
        @Override
        public String toString(){
            return index +" "+ value;
        }
    }
}