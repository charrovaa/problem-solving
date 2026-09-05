import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long) times[0] * n;

        while (min != max) {
            long time = (max + min) / 2;
            long cnt = 0;
            for (int t : times) cnt += time / t;
            if (cnt >= n) { // 해당 시간에 대상자만큼 혹은 더 많은 인원 처리 가능 시
                max = time;
            } else { // 해당 시간에 대상자보다 적은 인원 처리 가능 시
                min = time + 1;
            }
        }

        return min;
    }
}