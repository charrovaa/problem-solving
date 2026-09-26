class Solution {
    public int[] solution(int n, long left, long right) {

        int left_x = (int) (left % n);
        int left_y = (int) (left / n);
        int right_x = (int) (right % n);
        int right_y = (int) (right / n);

        boolean flag = false;

        int index = 0;
        int size = (int) (right - left + 1);
        int[] answer = new int[size];

        for (int i = left_y; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == left_x && i == left_y) flag = true;
                if (flag) {
                    answer[index++] = Math.max(i, j) + 1;
                    if (j == right_x && i == right_y) break;
                }
            }
            if (index == size) break;
        }

        return answer;
    }
}