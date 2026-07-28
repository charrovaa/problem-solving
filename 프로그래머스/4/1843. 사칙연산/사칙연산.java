import java.util.Arrays;

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
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < size; i++) { // 크기가 1인 집합 초기화
            max[i][i] = operand[i];
            min[i][i] = operand[i];
        }

        for (int i = 2; i <= size; i++) { // 두 집합의 크기 합 (전체 크기)
            for (int start = 0; start <= size - i; start++) { // 두 집합의 시작 인덱스
                for (int k = 1; k < i; k++) { // 좌측 구간의 크기
                    String curOp = operator[start + k - 1];
                    int mid = start + k - 1;
                    int end = start + i - 1;
                    if (curOp.equals("+")) {
                        max[start][end] = Math.max(max[start][end], max[start][mid] + max[mid + 1][end]);
                        min[start][end] = Math.min(min[start][end], min[start][mid] + min[mid + 1][end]);
                    } else {
                        max[start][end] = Math.max(max[start][end], max[start][mid] - min[mid + 1][end]);
                        min[start][end] = Math.min(min[start][end], min[start][mid] - max[mid + 1][end]);
                    }
                }
            }
        }

        return max[0][size - 1];
    }
}