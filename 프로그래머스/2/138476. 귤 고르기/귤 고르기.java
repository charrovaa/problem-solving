import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] sizes = new int[10_000_000 + 1];
        int answer = 0;

        for (int t : tangerine) {
            sizes[t]++;
        }

        Arrays.sort(sizes);

        for (int i = sizes.length - 1; i >= 0; i--) {
            k -= sizes[i];
            answer++;
            if (k <= 0) return answer;
        }

        return -1;
    }
}