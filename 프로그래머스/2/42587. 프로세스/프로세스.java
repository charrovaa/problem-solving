import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Node(priorities[i], i));
        }

        int count = 0;

        while (true) {
            Node node = queue.poll();
            boolean hasBigger = false;
            for (Node n : queue) {
                if (n.value > node.value) {
                    hasBigger = true;
                }
            }

            if (hasBigger) {
                queue.offer(node);
            } else {
                count++;
                if (node.originIndex == location) return count;
            }
        }
    }
}

class Node {
    int value;
    int originIndex;

    Node (int value, int originIndex) {
        this.value = value;
        this.originIndex = originIndex;
    }
}