class Solution {
    int N;
    int[][] adjacency;
    boolean[] visited;
    int min;
    public int solution(int n, int[][] wires) {
        N = n;
        adjacency = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int val_1 = wires[i][0];
            int val_2 = wires[i][1];
            adjacency[val_1][val_2] = adjacency[val_2][val_1] = 1;
        }

        dfs(1);

        return min;
    }

    int dfs(int towerNum) {
        int count = 1;
        visited[towerNum] = true;
        for (int i = 1; i <= N; i++) {
            if (adjacency[towerNum][i] == 1 && !visited[i]) {
                count+= dfs(i);
            }
        }

        min = Math.min(min, Math.abs(count - (N - count)));
        
        return count;
    }
}