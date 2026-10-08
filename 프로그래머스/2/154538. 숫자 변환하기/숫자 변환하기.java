class Solution {
    public int solution(int x, int y, int n) {
        int INF = Integer.MAX_VALUE;
        int[] dp = new int[y + 1];
        java.util.Arrays.fill(dp, INF);
        dp[y] = 0;

        for (int i = y - 1; i >= x; i--) {
            if (i * 2 < dp.length && dp[i * 2] != INF) dp[i] = Math.min(dp[i], dp[i * 2] + 1);
            if (i * 3 < dp.length && dp[i * 3] != INF) dp[i] = Math.min(dp[i], dp[i * 3] + 1);
            if (i + n <= y && dp[i + n] != INF) dp[i] = Math.min(dp[i], dp[i + n] + 1);
        }

        return dp[x] == INF ? -1 : dp[x];
    }
}