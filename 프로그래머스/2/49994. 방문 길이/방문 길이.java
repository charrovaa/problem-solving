import java.util.*;

class Solution {
    static final int MAX_COORD = 10; // 0 ~ 10

    private record Point(int x, int y) {}
    private record Edge(Point p1, Point p2) {
        Edge {
            if (p1.x() > p2.x() || (p1.x() == p2.x() && p1.y() > p2.y())) {
                Point temp = p1;
                p1 = p2;
                p2 = temp;
            }
        }
    }

    public int solution(String dirs) {
        Set<Edge> visited = new HashSet<>();

        Point cur = new Point(5, 5);
        for (char dir : dirs.toCharArray()) {
            int dx = 0, dy = 0;
            switch (dir) {
                case 'U' -> dy += 1;
                case 'D' -> dy -= 1;
                case 'R' -> dx += 1;
                case 'L' -> dx -= 1;
                default -> throw new IllegalArgumentException();
            }

            Point next = new Point(cur.x() + dx, cur.y() + dy);
            if (!inBounds(next.x(), next.y())) continue;
            visited.add(new Edge(cur, next));
            cur = next;
        }

        return visited.size();
    }

    static private boolean inBounds(int x, int y) {
        return x >= 0 && x <= MAX_COORD && y >= 0 && y <= MAX_COORD;
    }
}