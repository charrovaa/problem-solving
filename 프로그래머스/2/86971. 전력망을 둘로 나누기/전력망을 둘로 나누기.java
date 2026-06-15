import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int count;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1]; // 인접 리스트
        visited = new boolean[n + 1];
        count = 0; // 한쪽 트리에 속한 노드 개수
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            int a = wire[0];
            int b = wire[1];

            // 연산
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            dfs(a);
            min = Math.min(min, Math.abs(count - (n - count)));

            // 초기화
            count = 0;
            Arrays.fill(visited, false);
            graph[a].add(b);
            graph[b].add(a);

        }
        return min;
    }

    void dfs(int towerNum) { // towerNum과 인접한 숫자의 개수를 카운트
        visited[towerNum] = true;
        count++;
        for (int next : graph[towerNum]) {
            if (!visited[next]) dfs(next);
        }
    }
}