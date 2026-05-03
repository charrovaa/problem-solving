import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Stack<Integer> truck = new Stack<>(); // 트럭의 무게
        Map<Integer, Integer> bridge = new HashMap<>(); // 다리에 올라간 시점 + 다리의 길이, 무게

        for (int i = truck_weights.length - 1; i >= 0; i--) {
            truck.add(truck_weights[i]);
        }

        int answer = 0;

        while (!truck.isEmpty() || !bridge.isEmpty()) {

            answer++;

            if (bridge.containsKey(answer)) bridge.remove(answer);

            int sum = bridge.values().stream().mapToInt(Number::intValue).sum();

            if (!truck.isEmpty()) {
                if (truck.peek() + sum <= weight) {
                    bridge.put(answer + bridge_length, truck.pop());
                }
            }
        }

        return answer;
    }
}