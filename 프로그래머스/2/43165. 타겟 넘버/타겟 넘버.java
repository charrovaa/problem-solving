class Solution {
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        return dfs(0, 0);
    }

    // dfs(이번에 처리할 인덱스, 앞서 계산된 값)
    private int dfs(int index, int val) {
        int answer = 0;
        if (index < numbers.length - 1) {
            answer += dfs(index + 1, val + numbers[index]);
            answer += dfs(index + 1, val - numbers[index]);
        } else {
            // 마지막 인덱스인 경우 계산 후 리턴
            if (val + numbers[index] == target) answer++;
            if (val - numbers[index] == target) answer++;
        }
        return answer;
    }
}