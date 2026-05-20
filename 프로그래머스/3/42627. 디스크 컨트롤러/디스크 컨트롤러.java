import java.util.*;

class Solution {
    public int solution(int[][] jobs) {

        // {요청 시점, 소요 시간}
        Arrays.sort(jobs, (x, y) -> x[0] - y[0]); // 0. 요청 시점 기준 정렬
        Queue<int[]> queue = new PriorityQueue<int[]>((x, y) -> x[1] - y[1]); // 1. 소요 시간 기준 정렬
        int[] workingOn = null;

        int returnTime = 0;
        int index = 0;
        int time = 0;

        while (workingOn != null || !queue.isEmpty() || index < jobs.length) {
            while (index < jobs.length) {
                if (jobs[index][0] == time) { // 같은 요청 시점을 갖고 있는 경우 해당 요청 시점일 때
                    queue.add(jobs[index++]); // 대기 큐에 삽입
                } else {
                    break;
                }
            }

            if (workingOn == null && !queue.isEmpty()) {
                workingOn = queue.poll();
            }

            time++;

            if (workingOn != null) {
                workingOn[1]--;
                if (workingOn[1] == 0) {
                    returnTime += time - workingOn[0];
                    workingOn = null;
                }
            }
        }

        return returnTime / jobs.length;
    }
}