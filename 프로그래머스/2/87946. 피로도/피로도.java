class Solution {

    int[][] dungeons; // [최소 필요 피로도][소모 피로도]
    boolean[] visited;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        dfs(k, answer);
        return answer;
    }

    private void dfs(int currentFatigue, int visitedCount) { // 현재 잔여 피로도, 방문 횟수
        for (int i = 0; i < visited.length; i++) {
            answer = Math.max(answer, visitedCount);
            if (visited[i] == false) {
                if (currentFatigue - dungeons[i][0] >= 0) {
                    visited[i] = true;
                    dfs(currentFatigue - dungeons[i][1], visitedCount + 1);
                    visited[i] = false;
                }
            }
        }
    }
}