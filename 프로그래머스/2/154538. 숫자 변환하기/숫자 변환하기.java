import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int[] res = new int[y + 1];
        Arrays.fill(res, -1);
        res[x] = 0;
        for (int i = x + 1; i <= y; i++) {
            if (i % 2 == 0 && res[i / 2] != -1) {
                if (res[i] == -1) res[i] = res[i / 2] + 1;
                else res[i] = Math.min(res[i], res[i / 2] + 1);
            }
            if (i % 3 == 0 && res[i / 3] != -1) {
                if (res[i] == -1) res[i] = res[i / 3] + 1;
                else res[i] = Math.min(res[i], res[i / 3] + 1);
            }
            if (i - n >= 0 && res[i - n] != -1) {
                if (res[i] == -1) res[i] = res[i - n] + 1;
                else res[i] = Math.min(res[i], res[i - n] + 1);
            }
        }
        return res[y];
    }
}