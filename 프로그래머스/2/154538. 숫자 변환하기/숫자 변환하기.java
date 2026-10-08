class Solution {
    public int solution(int x, int y, int n) {
        int INF = Integer.MAX_VALUE;
        int[] dp = new int[y + 1];
        java.util.Arrays.fill(dp, INF);
        dp[x] = 0;

        for (int i = x + 1; i <= y; i++) {
            if (i % 2 == 0 && dp[i / 2] != INF) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0 && dp[i / 3] != INF) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i - n >= x && dp[i - n] != INF) dp[i] = Math.min(dp[i], dp[i - n] + 1);
        }

        return dp[y] == INF ? -1 : dp[y];
    }
}