import java.util.*;
class Solution {
    static int[][] check;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] table = new List[n+1];
        for(int i = 1; i <= n; i++){
            table[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            table[a].add(b);
            table[b].add(a);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        while(!q.isEmpty()){
            int currNode = q.remove();
            for(int nextNode : table[currNode]){
                if(dist[nextNode] == -1){
                    dist[nextNode] = dist[currNode] + 1;
                    q.add(nextNode);
                }
            }
        }
        int maxDepth = 0;
        for(int d : dist){
            if(d == -1) continue;
            maxDepth = Math.max(maxDepth, d);
        }
        for(int d : dist){
            if(d == maxDepth){
                answer++;
            }
        }
        
        return answer;
    }
}