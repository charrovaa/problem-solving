class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }

    // dfs(이번에 처리할 인덱스, 앞서 계산된 값, 숫자 배열, 타켓 숫자)
    private int dfs(int index, int val, int[] numbers, int target) {
        if (index == numbers.length) {
            if (val == target) return 1;
            return 0;
        } else {
            return dfs(index + 1, val + numbers[index], numbers, target) + dfs(index + 1, val - numbers[index], numbers, target);
        }
    }
}