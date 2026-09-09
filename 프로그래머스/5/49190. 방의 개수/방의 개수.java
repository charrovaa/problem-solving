import java.util.*;

class Solution {

    private record Node(int x, int y) {}
    private record Edge(Node pre, Node cur) {}

    // 내부 방 = 간선 - 정점 + 교차점 + 1

    /*
    1. 정점 저장 (중복 제거)
    2. 간선 저장 (방향 및 중복 제거)
    */

    public int solution(int[] arrows) {

        int[][] directions = new int[][]{
            {0, 1}, {1, 1}, {1, 0}, {1, -1},
            {0, -1}, {-1, -1}, {-1, 0}, {-1, 1},
        };

        Set<Node> nodes = new HashSet<>();
        Node preNode = new Node(0, 0);
        nodes.add(preNode);

        Set<Edge> edges = new HashSet<>();

        int cross = 0;

        for (int arrow : arrows) {
            // 정점 추가
            Node curNode = new Node(preNode.x() + directions[arrow][0], preNode.y() + directions[arrow][1]);
            nodes.add(curNode);

            Edge edge;

            // 간선 추가
            if (preNode.x() < curNode.x()) {
                edge = new Edge(preNode, curNode);
            } else if (preNode.x() > curNode.x()) {
                edge = new Edge(curNode, preNode);
            } else {
                if (preNode.y() < curNode.y()) edge = new Edge(preNode, curNode);
                else edge = new Edge(curNode, preNode);
            }

            // 교차 간선 확인 (+1)
            if (!edges.contains(edge) && arrow % 2 ==  1) {
                int minX = Math.min(preNode.x(), curNode.x());
                int minY = Math.min(preNode.y(), curNode.y());

                Node ld = new Node(minX, minY);
                Node rd = new Node(minX + 1, minY);
                Node lu = new Node(minX, minY + 1);
                Node ru = new Node(minX + 1, minY + 1);

                boolean isRu = (arrow == 1) || (arrow == 5); // 우상향 대각선 (/)

                Edge opposite = isRu ? new Edge(lu, rd) : new Edge(ld, ru);

                if (edges.contains(opposite)) cross++;
            }

            edges.add(edge);
            preNode = curNode;
        }

        return edges.size() - nodes.size() + cross + 1;
    }
}