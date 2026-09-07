import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        int max = distance;
        int min = 1;

        while (min != max) {
            int mid = (max + min + 1) / 2;
            int last = 0;
            int cnt = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - last < mid) {
                    cnt++;
                } else {
                    last = rocks[i];
                }
            }

            if (distance - last < mid) cnt++;

            if (cnt <= n) { // 주어진 횟수보다 적거나 같게 제거한 경우
                min = mid;
            } else {
                // 주어진 횟수보다 많게 제거한 경우
                max = mid - 1;
            }
        }

        return max;
    }
}