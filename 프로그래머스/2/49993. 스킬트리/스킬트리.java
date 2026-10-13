class Solution {
    public int solution(String skill, String[] skill_trees) {

        boolean[] isSkill = new boolean['Z' - 'A' + 1];
        int cnt = 0;

        for (char c : skill.toCharArray()) isSkill[c - 'A'] = true;

        for (String skill_tree : skill_trees) {
            int idx = 0;
            boolean flag = false;
            for (char c : skill_tree.toCharArray()) {
                if (isSkill[c - 'A']) {
                    if (skill.toCharArray()[idx] != c) {
                        flag = true;
                        break;
                    }
                    else idx++;
                    if (idx == skill.length()) break;
                }
            }
            if (!flag) cnt++;
        }

        return cnt;
    }
}