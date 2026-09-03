import java.util.*;

class Solution {
    boolean[] visited;
    String[] bestRoute;
    boolean flag;

    public String[] solution(String[][] tickets) {
        this.visited = new boolean[tickets.length];
        this.bestRoute = new String[tickets.length + 1];
        this.flag = false;

        // 티켓 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) {
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });

        dfs(0, "ICN", "ICN", tickets);

        return bestRoute;
    }

    private void dfs(int cnt, String departure, String route, String[][] tickets) {
        if (flag) return;
        if (cnt == tickets.length) {
            bestRoute = route.split(" ");
            flag = true;
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (departure.equals(tickets[i][0]) && !visited[i]) {
                    visited[i] = true;
                    dfs(cnt + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                    visited[i] = false;
                }
            }
        }
    }
}