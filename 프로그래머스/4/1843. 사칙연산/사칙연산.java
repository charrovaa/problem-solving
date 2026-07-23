class Solution {
    public int solution(String arr[]) {
        // 숫자 : arr의 0, 짝수 인덱스
        int size = arr.length / 2 + 1; // 숫자의 수
        int[][] max = new int[size][size]; // int[첫 번째 숫자의 인덱스][마지막 숫자의 인덱스]
        int[][] min = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }

        // 그룹의 원소가 하나인 경우
        for (int i = 0; i < size; i++) {
            max[i][i] = Integer.parseInt(arr[i * 2]);
            min[i][i] = Integer.parseInt(arr[i * 2]);
        }

        // 그룹의 원소가 두 개 이상인 경우
        for (int i = 2; i <= size; i++) { // 집합의 크기 (2개 ~ 모든 원소)
            for (int j = 0; j < size - i + 1; j++) { // 집합의 첫 번째 원소의 인덱스 (첫 번째 인덱스, 마지막 인덱스) = (j, j + i - 1)
                for (int k = 1; k < i; k++) { // 집합을 2개로 나눴을 때 첫 번째 그룹의 크기
                    String exp = arr[j * 2 + k * 2 - 1]; // 두 개의 집합 사이의 연산자
                    if (exp.equals("+")) {
                        max[j][j + i - 1] = Math.max(max[j][j + k - 1] + max[j + k][j + i - 1], max[j][j + i - 1]);
                        min[j][j + i - 1] = Math.min(min[j][j + k - 1] + min[j + k][j + i - 1], min[j][j + i - 1]);
                    } else {
                        max[j][j + i - 1] = Math.max(max[j][j + k - 1] - min[j + k][j + i - 1], max[j][j + i - 1]);
                        min[j][j + i - 1] = Math.min(min[j][j + k - 1] - max[j + k][j + i - 1], min[j][j + i - 1]);
                    }
                }
            }
        }

        return max[0][size - 1];
    }
}