class Solution {
    final char[] chars = new char[]{'A', 'E', 'I', 'O', 'U'};
    String target;
    boolean found;
    int count;
    public int solution(String word) {
        target = word;
        found = false;
        count = 0;

        for (int i = 0; i < chars.length; i++) {
            dfs(String.valueOf(chars[i]));
            if (found) break;
        }

        return count;
    }

    void dfs(String word) {
        // 카운트 증가
        count++;

        // 목표 확인
        if (word.equals(target)) {
            found = true;
            return;
        }

        // 길이 확인
        if (word.length() == 5) return;

        // 재귀
        for (int i = 0; i < chars.length; i++) {
            dfs(word + String.valueOf(chars[i]));
            if (found) break;
        }
    }
}