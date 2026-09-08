import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1]; // 1 ~ n
        Arrays.fill(visited, -1);
        int max = 0;

        queue.offer(1);
        visited[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] e : edge) {
                if (e[0] != cur && e[1] != cur) continue;
                int next = (e[0] != cur) ? e[0] : e[1];
                if (visited[next] != -1) continue;
                queue.offer(next);
                visited[next] = visited[cur] + 1;
                max = visited[next];
            }
        }

        int answer = 0;

        for (int i : visited) {
            if (i == max) answer++;
        }

        return answer;
    }
}