import java.util.*;
class Solution {
    static Set<Set<String>> resultSet;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        // 제재 아이디 목록을 담을 set생성
        resultSet = new HashSet<>();
        // 제재 아이디들을 각각의 banned_id에 맞게 저장해줄 list생성
        List<List<String>> list = new ArrayList<>();
        // banned_id를 기반으로 순회
        for(int b = 0; b < banned_id.length; b++){
            List<String> innerList = new ArrayList<>();
            for(int u = 0; u < user_id.length; u++){
                if(isMatch(user_id[u], banned_id[b])){
                    innerList.add(user_id[u]);
                }
            }
            list.add(innerList);
        }
        // 위에서 찾은 list를 기반으로 set에 제재 아이디 목록들을 만들어줌
        find(list, 0, new HashSet<String>());
        return resultSet.size();
    }
    public void find(List<List<String>> list, int cnt, Set<String> idSet){
        // cnt는 banned_id의 개수와 일치해야 종료할 수 있다.
        if(cnt == list.size()){
            // 그리고 지금 찾은 제재 아이디 목록개수 또한 일치해야지만 set을 저장할 수 있다.
            if(idSet.size() == list.size()){
                resultSet.add(new HashSet<>(idSet));
            }
            return;
        }
        // 반복문을 통해 cnt번쨰 불량사용자에 해당하는 아이디들을 set에 저장한다.
        for(String id : list.get(cnt)){
            if(idSet.contains(id) == false){
                idSet.add(id);
                find(list, cnt+1, idSet);
                idSet.remove(id);
            }
        }
    }
    public boolean isMatch(String userId, String bannedId){
        boolean check = true;
        // 자리수 확인
        if(userId.length() != bannedId.length()){
            return false;
        }
        // 돌아가며 확인
        for(int i = 0; i < userId.length(); i++){
            if(userId.charAt(i) != bannedId.charAt(i) && bannedId.charAt(i) != '*'){
                check = false;
                break;
            }
        }
        return check;
    }
}