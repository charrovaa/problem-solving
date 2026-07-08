import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 1;
        int out = routes[0][1];
        for (int[] route : routes) {
            // 경로의 출발 지점이 카메라 범위가 아닌 경우
            if (route[0] > out) {
                out = route[1];
                answer++;
            }
        }
        return answer;
    }
}