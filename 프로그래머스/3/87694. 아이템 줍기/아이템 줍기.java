import java.util.*;

class Solution {
    final int SIZE = 100;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        boolean[][] route = new boolean[SIZE + 1][SIZE + 1]; // [세로][가로]

        // 테두리 + 내부
        for (int i = 0; i < rectangle.length; i++) { // 각 사각형
            for (int j = rectangle[i][0] * 2; j <= rectangle[i][2] * 2; j++) { // 사각형의 가로
                for (int k = rectangle[i][1] * 2; k <= rectangle[i][3] * 2; k++) { // 사각형의 세로
                    route[k][j] = true;
                }
            }
        }

        // 내부 걸러내기
        for (int i = 0; i < rectangle.length; i++) { // 각 사각형
            for (int j = rectangle[i][0] * 2 + 1; j <= rectangle[i][2] * 2 - 1; j++) { // 사각형의 가로
                for (int k = rectangle[i][1] * 2 + 1; k <= rectangle[i][3] * 2 - 1; k++) { // 사각형의 세로
                    route[k][j] = false;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 상하좌우

        while (!queue.isEmpty()) {
            int[] curLocation = queue.poll(); // {가로 좌표, 세로 좌표, 레벨}

            if (curLocation[0] == itemX * 2 && curLocation[1] == itemY * 2) return curLocation[2] / 2;

            for (int[] direction : directions) {
                if (curLocation[0] + direction[0] >= 0 && curLocation[0] + direction[0] <= SIZE &&
                    curLocation[1] + direction[1] >= 0 && curLocation[1] + direction[1] <= SIZE &&
                    route[curLocation[1] + direction[1]][curLocation[0] + direction[0]]
                ) {
                    queue.offer(new int[]{curLocation[0] + direction[0], curLocation[1] + direction[1], curLocation[2] + 1});
                    route[curLocation[1] + direction[1]][curLocation[0] + direction[0]] = false;
                }
            }
        }
        return -1;
    }
}