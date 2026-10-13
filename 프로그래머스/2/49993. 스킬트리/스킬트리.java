class Solution {
    public int solution(String skill, String[] skill_trees) {
        int cnt = 0;
        for (String skill_tree : skill_trees) if (isValid(skill, skill_tree)) cnt++;
        return cnt;
    }

    private boolean isValid(String skill, String skill_tree){
        int idx = 0;
        for (char c : skill_tree.toCharArray()) {
            int pos = skill.indexOf(c);
            if (pos == -1) continue; // 스킬 목록에 없는 경우
            if (pos != idx++) return false; // 스킬 순서 위반
        }
        return true;
    }
}