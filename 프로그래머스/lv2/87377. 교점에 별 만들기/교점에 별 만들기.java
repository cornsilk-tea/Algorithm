import java.util.*;
class Solution {
    
    private static class Point {
        // 데이터를 나타내는 클래스이므로 불변성을 갖게한다.
        // 죄표범위가 주어지지 않았기 때문에 long으로 한다. 그래야 오버플로우가 발생하지 않는다.
        public final long x,y;
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        String[] answer = {};
        //Ax + By + C = 0
        // 좌표를 저장할 리스트 만들기
        List<Point> points = new ArrayList<>();

        // 모든 직선쌍에 대해 반복하기 위해 이중반복문 사용
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                // line[i], line[j]를 이용하여 차례로 수행
                // 교점 좌표 구하기
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                // 정수의 값이 넘어오면 리스트에 저장
                if(intersection != null){
                    points.add(intersection);
                }
            }
        }
        
        // 최대값 최솟값 구하기
        Point min = getMinPoint(points);
        Point max = getMaxPoint(points);
        
        // 구한 최대값 최소값을 이용하여 2차원 배열의 크기 결정
        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);
        
        char[][] arr = new char[height][width];
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }
        
        // 2차원 배열에 별 찍기
        for(Point p : points){
            /*
                주의사항
                2차원 배열의 0,0은 실제 0,0이 아님
                좌표값을 변경해줘야 함.
                2차원 배열의 좌표는 일반좌표와 비교했을떄 y축 방향이 반대고 min, max로 크기가 결정됐다.
                y좌표로 먼저 접근 후 x좌표로 접근해야 한다.
            */
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            arr[y][x] = '*';
        }
        // arr을 문자열 배열로 저장 후 반환하기
        String[] result = new String[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new String(arr[i]);
        }
        
        return result;
    }
    
    // 두 직선의 정보를 받아 그 교점이 정수이면 Point객체를 반환하는 메서드
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2){
        // 교점을 구하기
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        // 정수가 아니면 null 반환하기.
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long) x, (long) y);
    }
    
    // 가장 작은 좌표 찾기
    private Point getMinPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(p.x < x)
                x = p.x;
            if(p.y < y)
                y = p.y;
        }
        return new Point(x,y);
    }
    
    // 가장 큰 좌표 찾기
    private Point getMaxPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(p.x > x)
                x = p.x;
            if(p.y > y)
                y = p.y;
        }
        return new Point(x,y);
    }
}












