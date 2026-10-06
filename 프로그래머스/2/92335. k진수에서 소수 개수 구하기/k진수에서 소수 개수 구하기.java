class Solution {
    public int solution(int n, int k) {
        String[] nums = Integer.toString(n, k).split("0");
        int ans = 0;

        for (String snum : nums) {
            if (snum.isEmpty()) continue;
            if (isPrime(Long.parseLong(snum))) ans++;
        }

        return ans;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}