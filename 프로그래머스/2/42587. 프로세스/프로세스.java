import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int answer = 0;

        for (int i : priorities) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) { // 배열의 값이 최댓값이라면?
                    queue.poll();
                    answer++;
                    if (i == location) return answer;
                }
            }
        }
        return answer;
    }
}