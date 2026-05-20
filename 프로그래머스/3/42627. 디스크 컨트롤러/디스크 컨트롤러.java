import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // int[][] jobs = {}{요청 시점, 소요 시간}
        int[][] ijobs = new int[jobs.length][3];
        // int[][] ijobs = {}{소요 시간, 요청 시점, 인덱스}
        for (int i = 0; i < ijobs.length; i++) {
            ijobs[i][0] = jobs[i][1]; // 1순위 : 소요 시간
            ijobs[i][1] = jobs[i][0]; // 2순위 : 요청 시점
            ijobs[i][2] = i; // 3순위 : 인덱스
        }
        // 요청 시점에 따른 오름차순 정렬 (대기 큐에 들어가는 순서)
        Arrays.sort(ijobs, (x, y) -> x[1] - y[1]);

        // 대기큐 (우선 순위에 따른 정렬)
        Queue<int[]> pq = new PriorityQueue<int[]>((x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            else if (x[1] != y[1]) return x[1] - y[1];
            else return x[2] - y[2];
        });

        // 이번에 대기열로 들어갈 작업의 인덱스
        int index = 0;
        // 진행 시각
        int time = 0;
        // 반환 시간의 합
        int answer = 0;

        while (true) {
            // 모든 작업들이 대기열에 들어갔으며 동시에 대기열이 비었을 때 종료
            if (index == ijobs.length && pq.isEmpty()) break;

            // 해당 시점에 대기열에 들어갈 수 있는 작업들 추가
            while (index < ijobs.length && ijobs[index][1] <= time) {
                pq.add(ijobs[index++]);
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[0];
                answer += time - job[1];
            } else {
                time = ijobs[index][1];
            }
        }

        return answer / ijobs.length;
    }
}