import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        int answer = 0;
        for (Integer i : list) {
            k -= i;
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}