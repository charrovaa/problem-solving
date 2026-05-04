import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] answer = new int[prices.length];

        deque.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!deque.isEmpty() && prices[deque.peek()] > prices[i]) {
                int index = deque.pop();
                answer[index] = i - index;
            }
            deque.push(i);
        }

        while (!deque.isEmpty()) {
            int index = deque.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}