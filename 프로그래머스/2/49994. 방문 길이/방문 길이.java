import java.util.*;

record Point(int x, int y) {}
record Edge(Point p1, Point p2) {}

class Solution {
    static final int SIZE = 10;
    public int solution(String dirs) {
        Set<Edge> visited = new HashSet<>();
        int ans = 0;

        Point cur = new Point(5, 5);
        for (char dir : dirs.toCharArray()) {

            Point next = null;
            Edge edge;

            if (dir == 'U') {
                if (cur.y() + 1 > SIZE) continue;
                next = new Point(cur.x(), cur.y() + 1);
            } else if (dir == 'D') {
                if (cur.y() - 1 < 0) continue;
                next = new Point(cur.x(), cur.y() - 1);
            } else if (dir == 'R') {
                if (cur.x() + 1 > SIZE) continue;
                next = new Point(cur.x() + 1, cur.y());
            } else if (dir == 'L') {
                if (cur.x() - 1 < 0) continue;
                next = new Point(cur.x() - 1, cur.y());
            } else {
                throw new IllegalArgumentException();
            }

            if (cur.x() < next.x()) edge = new Edge(cur, next);
            else if (cur.x() > next.x()) edge = new Edge(next, cur);
            else {
                if (cur.y() < next.y()) edge = new Edge(cur, next);
                else edge = new Edge(next, cur);
            }

            if (!visited.contains(edge)) ans++;
            visited.add(edge);
            cur = next;
        }

        return ans;
    }
}