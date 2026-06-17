class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        int answer = n;
        for (int i : lost) {
            students[i - 1]--;
        }
        for (int i : reserve) {
            students[i - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (students[i] == -1) { // 체육복이 없는 학생이라면
                if (i - 1 >= 0 && students[i - 1] == 1) {
                    // students[i]++;
                    // students[i - 1]--;
                } else if (i + 1 < n && students[i + 1] == 1) {
                    // students[i]++;
                    students[i + 1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}