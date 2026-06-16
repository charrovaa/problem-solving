class Solution {
    final char[] chars = new char[]{'A', 'E', 'I', 'O', 'U'};
    int count = 0;

    public int solution(String word) {
        dfs("", word);
        return count;
    }

    boolean dfs(String current, String target) {
        if (current.equals(target)) return true;
        if (current.length() == 5) return false;
        for (char c : chars) {
            count++;
            if (dfs(current + c, target)) return true;
        }
        return false;
    }
}