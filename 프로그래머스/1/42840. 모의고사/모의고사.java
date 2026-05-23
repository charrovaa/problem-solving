import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> answer = new ArrayList<Integer>();

        int[] set_1 = {1, 2, 3, 4, 5}; // 1번 수포자의 답안 집합
        int[] set_2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 2번 수포자의 답안 집합
        int[] set_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 3번 수포자의 답안 집합
        
        for (int i = 0; i < answers.length; i++) {
            if (set_1[i % set_1.length] == answers[i]) map.put(1, map.getOrDefault(1, 0) + 1);
            if (set_2[i % set_2.length] == answers[i]) map.put(2, map.getOrDefault(2, 0) + 1);
            if (set_3[i % set_3.length] == answers[i]) map.put(3, map.getOrDefault(3, 0) + 1);
        }

        int max = 0;

        for (int i : map.values()) {
            max = Math.max(i, max);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == max) answer.add(i);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}