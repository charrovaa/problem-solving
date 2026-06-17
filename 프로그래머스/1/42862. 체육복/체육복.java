import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        int answer;

        for (int i : lost) {
            lostList.add(i);
        }

        for (int i : reserve) {
            reserveList.add(i);
        }

        // 정렬
        Collections.sort(lostList);
        Collections.sort(reserveList);

        // 중복 제거
        for (int i = 1; i <= n; i++) {
            if (lostList.contains(Integer.valueOf(i)) && reserveList.contains(Integer.valueOf(i))) {
                lostList.remove(Integer.valueOf(i));
                reserveList.remove(Integer.valueOf(i));
            }
        }

        answer = n - lostList.size();

        for (int i = 0; i < lostList.size(); i++) {
            answer++;
            if (reserveList.contains(lostList.get(i) - 1)) {
                reserveList.remove(Integer.valueOf(lostList.get(i) - 1));
            } else if (reserveList.contains(lostList.get(i))) {
                reserveList.remove(Integer.valueOf(lostList.get(i)));
            } else if (reserveList.contains(lostList.get(i) + 1)) {
                reserveList.remove(Integer.valueOf(lostList.get(i) + 1));
            } else {
                answer--;
            }
        }
        
        return answer;
    }
}