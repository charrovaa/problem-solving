class Solution {
    public long solution(int n) {
        int[] dp = new int[n + 1];
        int divisor = 1234567;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) dp[i] = i;
            else dp[i] = (dp[i - 1] + dp[i - 2]) % divisor;
        }
        return dp[n];
    }
}