class Solution {
    public int solution(String skill, String[] skill_trees) {

        boolean[] isSkill = new boolean['Z' - 'A' + 1];
        int cnt = 0;

        for (char c : skill.toCharArray()) isSkill[c - 'A'] = true;

        for (String skill_tree : skill_trees) {
            if (isValid(isSkill, skill, skill_tree)) cnt++;
        }

        return cnt;
    }

    private boolean isValid(boolean[] isSkill, String skill, String skill_tree){
        int idx = 0;
        for (char c : skill_tree.toCharArray()) {
            if (!isSkill[c - 'A']) continue;
            if (skill.charAt(idx) != c) return false;
            if (++idx == skill.length()) return true;
        }
        return true;
    }
}