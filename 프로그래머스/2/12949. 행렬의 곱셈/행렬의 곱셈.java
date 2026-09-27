class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) { // 행
            for (int j = 0; j < arr2[0].length; j++) { // 열
                answer[i][j] = getElement(arr1, arr2, i, j);
            }
        }

        return answer;
    }

    private int getElement(int[][] arr1, int[][] arr2, int row, int col) {
        int sum = 0;
        for (int i = 0; i < arr1[0].length; i++) {
            sum += arr1[row][i] * arr2[i][col];
        }
        return sum;
    }
}