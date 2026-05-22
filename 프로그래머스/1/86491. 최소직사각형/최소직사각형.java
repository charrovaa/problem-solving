class Solution {
    public int solution(int[][] sizes) {
        int max = 0; // 지갑의 더 긴 모서리의 길이
        int min = 0; // 지갑의 더 짧은 모서리의 길이

        for (int[] is : sizes) {
            if (is[0] > is[1]) {
                if (max < is[0]) max = is[0];
                if (min < is[1]) min = is[1];
            } else {
                if (max < is[1]) max = is[1];
                if (min < is[0]) min = is[0];
            }
        }
        return max * min;
    }
}