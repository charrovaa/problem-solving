import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        boolean[][] board_visited = new boolean[game_board.length][game_board[0].length];
        boolean[][] table_visited = new boolean[game_board.length][game_board[0].length];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // 상하좌우 {y, x}
        int answer = 0;

        List<List<int[]>> game_board_shapes = new ArrayList<>();
        game_board_shapes = findShapes(game_board_shapes, game_board, 0, board_visited, directions); // 각 유효 구멍

        List<List<int[]>> table_shapes = new ArrayList<>();
        table_shapes = findShapes(table_shapes, table, 1, table_visited, directions); // 각 유효 도형
        boolean[] shape_used = new boolean[table_shapes.size()];

        for (List<int[]> hole : game_board_shapes) { // 각 구멍
            int size = hole.size();
            boolean hasShape = false;
            hole.sort((a, b) -> { 
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });
            for (int i = 0; i < table_shapes.size(); i++) { // 각 도형 (List<int[]> shapes : table_shapes)
                if (size != table_shapes.get(i).size()) continue;
                if (shape_used[i]) continue;

                List<List<int[]>> rotatedShapes = rotate(table_shapes.get(i)); // 각 도형에 대한 회전 도형 집합
                for (List<int[]> rotatedShape : rotatedShapes) { // 각 도형에 대한 회전 도형 중 하나
                    rotatedShape.sort((a, b) -> {
                        if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                        return Integer.compare(a[1], b[1]);
                    });
                    int cnt = 0;
                    for (int j = 0; j < size; j++) {
                        if (hole.get(j)[0] == rotatedShape.get(j)[0] && hole.get(j)[1] == rotatedShape.get(j)[1]) {
                            cnt++;
                        }
                    }
                    if (cnt == size) {
                        hasShape = true;
                        shape_used[i] = true;
                        break;
                    }
                }
                if (hasShape) {
                    answer += size;
                    break;
                }
            }
        }
        return answer;
    }

    // 도형 수집 (반환할 도형, 도형을 찾을 판, 도형을 표현한 방식, 좌표 방문 여부, 방향)
    private List<List<int[]>> findShapes(List<List<int[]>> shapes, int[][] board, int value, boolean[][] visited, int[][] directions) {
        for (int i = 0; i < board.length; i++) { // 행 방문 여부
            for (int j = 0; j < board[i].length; j++) { // 열 방문 여부
                if (board[i][j] != value) continue; // 도형이 아니면 넘어가기
                if (visited[i][j]) continue;
                // 해당 칸과 연결된 칸 찾기 (도형 찾기)
                Queue<int[]> queue = new LinkedList<>();
                List<int[]> shape = new LinkedList<>();

                int[] point = new int[]{i, j};
                queue.offer(point);
                shape.add(point);
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] block = queue.poll();
                    int y = block[0];
                    int x = block[1];
                    // 상하좌우 탐색
                    for (int[] direction : directions) {
                        if (y + direction[0] < 0 || y + direction[0] >= board.length) continue; // 범위 밖이거나
                        if (x + direction[1] < 0 || x + direction[1] >= board[i].length) continue;
                        if (board[y + direction[0]][x + direction[1]] != value) continue; // 도형이 아니거나
                        if (visited[y + direction[0]][x + direction[1]]) continue; // 이미 방문한 칸인 경우 넘어가기
                        point = new int[]{y + direction[0], x + direction[1]};
                        queue.offer(point);
                        shape.add(point);
                        visited[y + direction[0]][x + direction[1]] = true;
                    }
                }
                shapes.add(normalization(shape));
            }
        }
        return shapes;
    }

    // 도형의 좌표 정규화
    private List<int[]> normalization(List<int[]> shape) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        for (int[] point : shape) { // int[]{y, x}
            if (minX > point[1]) minX = point[1];
            if (minY > point[0]) minY = point[0];
        }

        List<int[]> norShape = new LinkedList<>();

        for (int[] point : shape) {
            norShape.add(new int[]{point[0] - minY, point[1] - minX});
        }

        return norShape;
    }

    // 도형 회전
    private List<List<int[]>> rotate(List<int[]> shape) {
        List<List<int[]>> newShapes = new ArrayList<>(); // 원본, 90, 180, 270
        newShapes.add(shape); // 원본 도형

        for (int i = 0; i < 3; i++) { // 90, 180, 270
            List<int[]> curShape = newShapes.getLast();
            List<int[]> nextShape = new LinkedList<>();

            int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

            for (int[] point : curShape) {
                if (minY > point[0]) minY = point[0];
                if (maxY < point[0]) maxY = point[0];
            }

            int height = maxY - minY + 1;

            for (int[] curPoint : curShape) {
                nextShape.add(new int[]{curPoint[1], height - curPoint[0] - 1});
            }
            newShapes.add(normalization(nextShape)); // 각 회전 도형 정규화 후 저장
        }
        return newShapes;
    }
}