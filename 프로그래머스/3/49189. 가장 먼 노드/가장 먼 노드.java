import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) { // V, E
        // 인접 리스트 생성
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<Integer>()); // V
        for (int[] e : edge) { // E
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1); // V

        // 초기화
        queue.offer(1);
        visited[1] = 0;

        // 반환값
        int cnt = 0;
        int max = 0;

        // BFS
        while (!queue.isEmpty()) { // V
            int cur = queue.poll();
            for (int next : list.get(cur)) { // 2E (E)
                if (visited[next] == -1) {
                    visited[next] = visited[cur] + 1;
                    max = visited[next];
                    queue.offer(next);
                }
            }
        }

        // 해당 노드 카운트
        for (int i : visited) { // V
            if (i == max) cnt++;
        }

        return cnt;
    }
}