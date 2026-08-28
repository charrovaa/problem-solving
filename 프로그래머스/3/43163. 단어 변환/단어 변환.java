class Solution {
    String begin;
    String target;
    String[] words;
    boolean[] visited;
    int answer;

    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        this.visited = new boolean[words.length];
        this.answer = Integer.MAX_VALUE;

        dfs(0, -1);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(int lev, int index) { // (이전 단계, 이전 인덱스)
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                String preWord = index < 0 ? begin : words[index];
                String curWord = words[i];
                visited[i] = true;

                if (preWord.equals(target)) {
                    if (answer > lev) answer = lev;
                }

                int diffCount = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if (preWord.charAt(j) != curWord.charAt(j)) {
                        if (diffCount > 1) break;
                        diffCount++;
                    }
                }
                if (diffCount <= 1) dfs(lev + 1, i);
                visited[i] = false;
            }
        }
    }
}