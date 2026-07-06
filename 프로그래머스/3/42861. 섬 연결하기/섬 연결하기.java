import java.util.Arrays;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        for (int[] edge : costs) {
            if (find(edge[0]) != find(edge[1])) { // 서로 다른 그룹이면
                union(edge[0], edge[1]); // 그룹을 합칠 것
                answer += edge[2];
            }
        }
        return answer;
    }
    // 그룹을 대표하는 값 찾기
    int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    // 다른 그룹의 대푯값 통일하기
    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}