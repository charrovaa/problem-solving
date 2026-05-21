import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        Queue<Integer> maxpq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 최대 힙
        Queue<Integer> minpq = new PriorityQueue<Integer>(); // 최소 힙
        Map<Integer, Integer> alive = new HashMap<Integer, Integer>(); // 지연 삭제 (값, 개수)
        int count = 0;

        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            if (st.nextToken().equals("I")) {
                // 숫자 삽입
                int number = Integer.parseInt(st.nextToken());
                maxpq.add(number);
                minpq.add(number);
                alive.put(number, alive.getOrDefault(number, 0) + 1);
                count++;
            } else {
                int number;
                if (count == 0) continue;
                String token = st.nextToken();
                while (true) {
                    if (token.equals("1")) {
                        number = maxpq.poll();
                    } else {
                        number = minpq.poll();
                    }
                    if (alive.get(number) != 0) break;
                }
                alive.put(number, alive.get(number) - 1);
                count--;
            }
        }

        int[] answer = new int[2];

        if (count == 0) return answer;

        answer[0] = Integer.MIN_VALUE;
        answer[1] = Integer.MAX_VALUE;

        for (int key : alive.keySet()) {
            int value = alive.get(key);
            if (value != 0) {
                answer[0] = key > answer[0] ? key : answer[0];
                answer[1] = key < answer[1] ? key : answer[1];
            }
        }
        
        return answer;
    }
}