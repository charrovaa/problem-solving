class Solution {
    int solution(int[][] land) {
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                land[i][j] += prevMax(land, i, j);
            }
        }

        for (int score : land[land.length - 1]) {
            ans = Math.max(ans, score);
        }

        return ans;
    }

    private int prevMax(int[][] land, int row, int col) {
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < land[row - 1].length; i++) {
            if (i == col) continue;
            curMax = Math.max(curMax, land[row - 1][i]);
        }
        return curMax;
    }
}