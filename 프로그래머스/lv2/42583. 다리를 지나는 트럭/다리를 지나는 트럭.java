import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        for(int i : truck_weights){
            start.add(i);
        }
        int bridgeWeight = 0;
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }
        while(!start.isEmpty()){
            // 다리위에 트럭들을 한칸씩 넘겨줌
            bridgeWeight -= bridge.remove();
            // 빈 공간에 트럭을 넣어줌
            // bridge의 무게가 weight이하여야 넣을 수 있다.
            if(bridgeWeight + start.get(0) <= weight){
                bridge.add(start.get(0));
                bridgeWeight += start.get(0);
                start.remove(0);
            }
            // 넣을 수 없다면 0을 넣어준다.
            else{
                bridge.add(0);
            }
            answer++;
            // System.out.println(bridge);
        }
        answer += bridge_length;
        return answer;
    }
}