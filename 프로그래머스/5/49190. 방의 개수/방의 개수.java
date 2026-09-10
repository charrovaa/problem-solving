import java.util.*;

class Solution {
    public int solution(int[] arrows) {

        record Node(int x, int y){};
        record Edge(Node x, Node y){};

        Set<Node> nodes = new HashSet<>();
        Set<Edge> edges = new HashSet<>();

        int answer = 0;

        Node pre = new Node(0, 0);
        nodes.add(pre);

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) { // 2배 스케일링
                int curX = pre.x();
                int curY = pre.y();

                if (arrow >= 1 && arrow <= 3) curX++;
                if (arrow >= 5 && arrow <= 7) curX--;
                if (arrow <= 1 || arrow == 7) curY++;
                if (arrow >= 3 && arrow <= 5) curY--;

                Node cur = new Node(curX, curY);
                Edge norEdge = new Edge(pre, cur);
                Edge oppEdge = new Edge(cur, pre);

                if (nodes.contains(cur)) {
                    if (!edges.contains(norEdge)) answer++;
                }

                nodes.add(cur);
                edges.add(norEdge);
                edges.add(oppEdge);

                pre = cur;
            }
        }

        return answer;
    }
}