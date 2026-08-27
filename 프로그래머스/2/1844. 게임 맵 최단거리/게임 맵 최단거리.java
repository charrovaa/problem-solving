import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        int row = maps[0].length; // 행
        int col = maps.length; // 열
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 {열, 행}

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // {열, 행, 거리}
        maps[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == col - 1 && cur[1] == row - 1) return cur[2];
            for (int[] d : directions) {
                int nRow = cur[1] + d[1];
                int nCol = cur[0] + d[0];
                int distance = cur[2];
                if (nCol >= 0 && nCol < col && nRow >= 0 && nRow < row && maps[nCol][nRow] == 1) {
                    queue.offer(new int[]{nCol, nRow, distance + 1});
                    maps[nCol][nRow] = 0;
                }
            }
        }
        return -1;
    }
}