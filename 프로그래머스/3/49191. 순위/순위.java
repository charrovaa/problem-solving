class Solution {
    public int solution(int n, int[][] results) {

        boolean[][] isWin = new boolean[n + 1][n + 1]; // 승자, 패자
        int cnt = n;

        for (int[] result : results) {
            isWin[result[0]][result[1]] = true;
        }

        for (int k = 1; k <= n; k++) { // 중간 다리
            for (int i = 1; i <= n; i++) { // 승자
                for (int j = 1; j <= n; j++) { // 패자
                    if (isWin[i][k] && isWin[k][j]) isWin[i][j] = true;
                }
            }

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (!isWin[i][j] && !isWin[j][i]) { // 경기 결과가 없다면
                    cnt--;
                    break;
                }
            }
        }

        return cnt;
    }
}