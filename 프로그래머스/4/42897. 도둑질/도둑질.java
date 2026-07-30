class Solution {
    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];

        // [0의 선택 유무(0 : 선택 / 1 : 미선택)][i까지 고려했을 때의 최대]
        dp[0][0] = money[0];
        dp[0][1] = money[0];
        dp[1][0] = 0;
        dp[1][1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
        }
        
        // 0을 고르고 마지막 원소를 고르지 않은 경우 / 0을 고르지 않고 마지막 원소까지 고려한 경우
        return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
    }
}