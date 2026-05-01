import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i : priorities) {
            queue.offer(i);
        }

        Arrays.sort(priorities); // 오름차순 정렬

        int answer = 0;

        while (!queue.isEmpty()) {
            int element = queue.poll();
            if (element == priorities[priorities.length - 1 - answer]) {
                answer++;
                if (--location < 0) {
                    break;
                }
            } else {
                queue.offer(element);
                if (--location < 0) {
                    location = queue.size() - 1;
                }
            }
        }
        return answer;
    }
}