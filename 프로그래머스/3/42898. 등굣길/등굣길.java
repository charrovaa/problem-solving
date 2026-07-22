class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (isPuddle[i][j]) {
                    continue;
                }
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}