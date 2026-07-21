class Solution {
    public int solution(int[][] triangle) {

        int[][] dp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int left = j - 1 < 0 ? 0 : dp[i - 1][j - 1]; // 각 행의 첫 번째 열인 경우 좌측 부모 0
                int right = j == dp[i].length - 1 ? 0 : dp[i - 1][j]; // 각 행의 마지막 열인 경우 우측 부모 0

                dp[i][j] = Math.max(left, right) + triangle[i][j];
            }
        }

        int max = 0;

        for (int i : dp[dp.length - 1]) {
            if (i > max) max = i;
        }

        return max;
    }
}