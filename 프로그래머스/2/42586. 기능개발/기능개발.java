import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int day = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < day) { // 앞의 작업보다 더 오래 걸리면?
                answer.add(q.size()); // 앞의 작업에 걸리는 시간을 answer에 저장 후
                q.clear(); // 큐 비우기
            } 
            q.offer(day);
        }
        answer.add(q.size());
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}