import java.util.*;

record Point(int x, int y) {}
record Edge(Point p1, Point p2) {
    Edge {
        if (p1.x() > p2.x() || (p1.x() == p2.x() && p1.y() > p2.y())) {
            Point temp = p1;
            p1 = p2;
            p2 = temp;
        }
    }
}

class Solution {
    static final int COORD = 10; // 0 ~ 10
    public int solution(String dirs) {
        Set<Edge> visited = new HashSet<>();

        Point cur = new Point(5, 5);
        for (char dir : dirs.toCharArray()) {

            Point next;
            if (dir == 'U') {
                if (cur.y() + 1 > COORD) continue;
                next = new Point(cur.x(), cur.y() + 1);
            } else if (dir == 'D') {
                if (cur.y() - 1 < 0) continue;
                next = new Point(cur.x(), cur.y() - 1);
            } else if (dir == 'R') {
                if (cur.x() + 1 > COORD) continue;
                next = new Point(cur.x() + 1, cur.y());
            } else if (dir == 'L') {
                if (cur.x() - 1 < 0) continue;
                next = new Point(cur.x() - 1, cur.y());
            } else {
                throw new IllegalArgumentException();
            }

            visited.add(new Edge(cur, next));
            cur = next;
        }

        return visited.size();
    }
}