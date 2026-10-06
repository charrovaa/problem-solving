class Solution {
    public int solution(int n, int k) {
        String[] nums = Integer.toString(n, k).split("0");
        int ans = 0;
        NEXT_TOKEN: for (String snum : nums) {
            if (snum.isEmpty()) continue;
            long lnum = Long.parseLong(snum);
            if (lnum < 2) continue;
            for (long i = 2; i * i <= lnum; i++) {
                if (lnum % i == 0) continue NEXT_TOKEN;
            }
            ans++;
        }
        return ans;
    }
}