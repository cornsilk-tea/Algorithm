import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        // 문자열 numbers를 int 배열로 변환
        int[] numArr = numbers.chars().map(n -> n - '0').toArray();
        // 소수를 저장할 Set를 생성
        Set<Integer> primes = new HashSet<>();
        // 재귀적으로 소수 찾기
        getPrimes(0, numArr, primes, new boolean[numArr.length]);
        // Set의 크기가 정답
        answer = primes.size();
        return answer;
    }
    
    private boolean isPrime(int num){
        // 1 이하는 소수가 아님
        if(num <= 1){
            return false;
        }
        // 2부터 주어진 수의 제곱근까지의 모든 수로 주어진 수를 나누기
        for(int n = 2; n <= Math.sqrt(num); n++){
            // 만약 주어진 수를 나눌 수 있으면 소수 아님
            if(num % n == 0)
                return false;
        }
        // 주어진 수를 나누는 수가 없으니 이건 소수임
        return true;
    }
    
    private void getPrimes(int currNum, int[] numArr, Set<Integer> primes, boolean[] visited){
        // 현재 숫자가 소수인지 판별하고, 소수라면 Set에 추가
        if(isPrime(currNum))
            primes.add(currNum);
        // 배열에 들어있는 모든 수 탐색
        for(int i = 0; i < numArr.length; i++){
            // 이미 사용된 숫자는 건너뛴다
            if(visited[i] == true)
                continue;
            // 이거 이제 사용함
            visited[i] = true;
            // 다음 숫자는 현재 숫자에 10을 곱하고 새로운 수 더한 값임
            int nextNum = currNum * 10 + numArr[i];            
            // 다음 숫자로 재귀 집어넣기
            getPrimes(nextNum, numArr, primes, visited);
            // 방문배열 되돌리기
            visited[i] = false;
        }
    }
}
