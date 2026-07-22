class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] p = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            p[puddle[1]][puddle[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p[i][j]) {
                    continue;
                }
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
                }
            }
        }

        return dp[n][m];
    }
}