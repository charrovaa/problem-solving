import java.util.*;

class Solution {
    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) { // 원소의 수
            for (int j = 0; j < elements.length; j++) { // 부분집합의 첫 원소의 인덱스
                int sum = 0;
                for (int k = 0; k < i; k++) { // 부분집합의 원소 더하기
                    int index = j + k >= elements.length ? j + k - elements.length : j + k;
                    sum += elements[index];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}