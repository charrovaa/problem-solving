class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                dp[i][j] = land[i][j] + prevMax(dp, i, j);
            }
        }

        return prevMax(dp, land.length, -1);
    }

    private int prevMax(int[][] dp, int row, int col) {
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (i == col) continue;
            curMax = Math.max(curMax, dp[row - 1][i]);
        }
        return curMax;
    }
}