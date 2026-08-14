class Solution {
    int[][] computers;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.visited = new boolean[n];
        int network = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 컴퓨터인 경우
                network++; // 새로운 네트워크로 간주
                dfs(i); // 해당 컴퓨터에서 연결된 모든 컴퓨터를 재귀적으로 탐색
            }
        }

        return network;
    }

    // 해당 컴퓨터와 직접 연결된 컴퓨터 탐색
    private void dfs(int computer) {
        visited[computer] = true; // 방문 완료
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && computers[computer][i] == 1) { // 아직 방문 안 하고 연결되어 있는 경우
                dfs(i); // 해당 컴퓨터 네트워크 탐색
            }
        }
    }
}