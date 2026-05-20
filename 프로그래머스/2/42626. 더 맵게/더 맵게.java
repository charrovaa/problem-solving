import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {

        Queue<Long> queue = new PriorityQueue<Long>();
        int count = 0;

        for (long i : scoville) {
            queue.add(i);
        }

        while (queue.size() >= 2) {
            long firstMin = queue.poll();
            long secondMin = queue.poll();

            if (firstMin >= K) {
                break;
            }

            queue.add(firstMin + (secondMin * 2));
            count++;
        }

        if (queue.size() == 1 && queue.peek() < K) return -1;
        return count;
    }
}