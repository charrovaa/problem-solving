import java.util.*;

class Solution {
    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];

        for (int i = 1; i <= elements.length; i++) { // 원소의 수
            for (int j = 0; j < elements.length; j++) { // 부분집합의 첫 원소의 인덱스
                dp[j] += elements[(j + i - 1) % elements.length];
                set.add(dp[j]);
            }
        }

        return set.size();
    }
}