class Solution {
    public int solution(String skill, String[] skill_trees) {
        int cnt = 0;
        for (String tree : skill_trees) if (skill.startsWith(tree.replaceAll("[^" + skill + "]", ""))) cnt++;
        return cnt;
    }
}