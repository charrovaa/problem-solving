import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        int answer;

        for (int i : lost) {
            lostSet.add(i);
        }

        for (int i : reserve) {
            reserveSet.add(i);
        }

        // 중복 제거
        Set<Integer> overlap = new HashSet<>(lostSet);
        overlap.retainAll(reserveSet); // 교집합
        lostSet.removeAll(overlap); // 각각 교집합 지우기
        reserveSet.removeAll(overlap);

        answer = n - lostSet.size();

        for (int i : lostSet) {
            if (reserveSet.remove(i - 1) || reserveSet.remove(i + 1)) answer++;
        }
        
        return answer;
    }
}