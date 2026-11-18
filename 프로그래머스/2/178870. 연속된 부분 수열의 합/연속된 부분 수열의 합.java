class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = -1, sum = 0;
        int[] ans = new int[]{0, sequence.length - 1};
        while (right < sequence.length) {
            if (sum < k) {
                if (++right < sequence.length) sum += sequence[right];
            } else if (sum > k) sum -= sequence[left++];
            else {
                if (right - left + 1 < ans[1] - ans[0] + 1) {
                    ans[1] = right;
                    ans[0] = left;
                }
                sum -= sequence[left++];
            }
        }
        return ans;
    }
}