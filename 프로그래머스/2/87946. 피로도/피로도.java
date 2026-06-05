class Solution {
    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons);
    }

    // 현재 상태에서 방문 가능한 최대 던전의 수
    int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for (int[] is : dungeons) {
            int required = is[0];
            int consumed = is[1];
            if (k >= required) {
                is[0] = 9999; // 재방문 불가능 설정
                cnt = Math.max(dfs(k - consumed, dungeons) + 1, cnt);
                is[0] = required;
            }
        }
        return cnt;
    }
}