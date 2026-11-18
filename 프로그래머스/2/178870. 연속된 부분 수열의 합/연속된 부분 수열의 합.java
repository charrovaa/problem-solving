class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = sequence.length - 1;
        int end = sequence.length - 1;
        int sum = sequence[end];
        int[] ans = new int[]{0, end};

        while (start > 0) {
            if (sum < k) sum += sequence[--start];
            else if (sum > k) sum -= sequence[end--];
            else {
                if (end - start + 1 <= ans[1] - ans[0] + 1) {
                    ans[0] = start;
                    ans[1] = end;
                }
                sum += sequence[--start];
                sum -= sequence[end--];
            }
        }

        while (end >= 0) {
            if (sum < k) break;
            else if (sum == k) {
                if (end + 1 <= ans[1] - ans[0] + 1) {
                    ans[0] = 0;
                    ans[1] = end;
                }
            }
            sum -= sequence[end--];
        }

        return ans;
    }
}