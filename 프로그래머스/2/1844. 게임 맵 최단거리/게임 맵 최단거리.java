import java.util.*;

class Solution {
    public int solution(int[][] maps) { // maps[y][x]
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0, 1}); // {y, x, distance}

        while (!queue.isEmpty()) {
            int[] curLocation = queue.poll(); // {y, x, distance}
            if (curLocation[0] == maps.length - 1 && curLocation[1] == maps[0].length - 1) {
                return curLocation[2];
            }

            if (curLocation[0] - 1 >= 0 && maps[curLocation[0] - 1][curLocation[1]] == 1) { // 상
                queue.offer(new int[]{curLocation[0] - 1, curLocation[1], curLocation[2] + 1});
                maps[curLocation[0] - 1][curLocation[1]] = 0;
            }
            if (curLocation[0] + 1 < maps.length && maps[curLocation[0] + 1][curLocation[1]] == 1) { // 하
                queue.offer(new int[]{curLocation[0] + 1, curLocation[1], curLocation[2] + 1});
                maps[curLocation[0] + 1][curLocation[1]] = 0;
            }
            if (curLocation[1] - 1 >= 0 && maps[curLocation[0]][curLocation[1] - 1] == 1) { // 좌
                queue.offer(new int[]{curLocation[0], curLocation[1] - 1, curLocation[2] + 1});
                maps[curLocation[0]][curLocation[1] - 1] = 0;
            }
            if (curLocation[1] + 1 < maps[0].length && maps[curLocation[0]][curLocation[1] + 1] == 1) { // 우
                queue.offer(new int[]{curLocation[0], curLocation[1] + 1, curLocation[2] + 1});
                maps[curLocation[0]][curLocation[1] + 1] = 0;
            }
        }
        return -1;
    }
}