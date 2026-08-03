class Solution {
    int[] numbers;
    int target, count;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.count = 0;
 
        dfs(0, numbers[0]);
        dfs(0, -numbers[0]);

        return count;
    }

    private void dfs(int index, int val) {

        int cur = index + 1;

        if (cur == numbers.length) {
            if (val == target) count++;
        } else {
            dfs(cur, val + numbers[cur]);
            dfs(cur, val - numbers[cur]);
        }
    }
}