class Solution {
    int[][] computers;
    boolean[] visited;
    int network;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.visited = new boolean[n];
        this.network = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                network++;
                dfs(i);
            }
        }

        return network;
    }

    private void dfs(int computer) {
        visited[computer] = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && computers[computer][i] == 1) {
                dfs(i);
            }
        }
    }
}