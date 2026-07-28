class Solution {
    public int solution(String arr[]) {

        int[] operand = new int[arr.length / 2 + 1]; // 피연산자
        String[] operator = new String[arr.length / 2]; // 연산자

        int size = operand.length;

        int[][] max = new int[size][size];
        int[][] min = new int[size][size];

        for (int i = 0; i < arr.length; i++) { // 피연산자, 연산자 초기화
            if (i % 2 == 0) operand[i / 2] = Integer.parseInt(arr[i]);
            if (i % 2 == 1) operator[i / 2] = arr[i];
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < operand.length; i++) { // 크기가 1인 집합 초기화
            max[i][i] = operand[i];
            min[i][i] = operand[i];
        }

        for (int i = 2; i <= size; i++) { // 두 집합의 크기 합 (전체 크기)
            for (int j = 0; j <= size - i; j++) { // 두 집합의 시작 인덱스
                for (int k = 1; k < i; k++) { // 집합 하나의 크기
                    String curOp = operator[j + k - 1];
                    int start = j;
                    int end = j + i - 1;
                    if (curOp.equals("+")) {
                        max[start][end] = Math.max(max[start][end], max[start][start + k - 1] + max[start + k][start + i - 1]);
                        min[start][end] = Math.min(min[start][end], min[start][start + k - 1] + min[start + k][start + i - 1]);
                    } else {
                        max[start][end] = Math.max(max[start][end], max[start][start + k - 1] - min[start + k][start + i - 1]);
                        min[start][end] = Math.min(min[start][end], min[start][start + k - 1] - max[start + k][start + i - 1]);
                    }
                }
            }
        }

        return max[0][size - 1];
    }
}