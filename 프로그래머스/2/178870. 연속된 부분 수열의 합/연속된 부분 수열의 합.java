class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = sequence.length - 1;
        int end = sequence.length - 1;
        int sum = sequence[end];
        int[] ans = new int[]{0, end};

        while (end >= 0) {
            if (sum < k) {
                if (start == 0) break;
                sum += sequence[--start];
            }
            else if (sum > k) sum -= sequence[end--];
            else {
                if (end - start + 1 <= ans[1] - ans[0] + 1) {
                    ans[0] = start;
                    ans[1] = end;
                }
                sum -= sequence[end--];
            }
        }

        return ans;
    }
}