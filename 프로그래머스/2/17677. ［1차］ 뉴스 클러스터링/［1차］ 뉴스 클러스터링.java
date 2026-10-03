import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Solution {
    public int solution(String str1, String str2) {
        final int DIVISOR = 65536;
        Map<String, Long> map1 = count(chunk(str1));
        Map<String, Long> map2 = count(chunk(str2));

        // concat       : 두 스트림을 이어 붙여 새 스트림 생성 (중복 제거 x)
        // collect      : 스트림의 값들을 하나의 결과물로 모으는 최종연산
        // Collectors   : Collector (모으는 방식) 생성 편의 메서드 모음
        Set<String> keySet = Stream.concat(map1.keySet().stream(), map2.keySet().stream())
                                   .collect(Collectors.toSet());

        int intersection = keySet.stream()
            .mapToInt(key -> Math.min(getCount(map1, key), getCount(map2, key)))
            .sum(); // 교집합
        int union = keySet.stream()
            .mapToInt(key -> Math.max(getCount(map1, key), getCount(map2, key)))
            .sum(); // 합집합

        if (union == 0) return 1 * DIVISOR;
        else return intersection * DIVISOR / union;
    }

    private String[] chunk(String str) {
        return IntStream.range(0, str.length() - 1)
                        .mapToObj(i -> str.substring(i, i + 2)) // IntStream은 int 전용이기에 String 매핑 시 mapToObj 사용
                        .toArray(String[]::new);
    }

    private String normalize(String input) {
        // allMatch : 스트림의 모든 요소가 조건을 만족하는가? 검사 후 boolean값을 반환하는 최종 연산
        String lower = input.toLowerCase();
        return lower.chars().allMatch(c -> c >= 'a' && c <= 'z') ? lower : null;
    }

    private Map<String, Long> count(String[] strs) {
        // Arrays.stream        : 배열을 스트림으로 변환
        // map                  : 각 요소를 다른 값으로 변환 (normalize 적용)
        // filter               : 조건에 맞는 요소만 통과 (null 제거)
        // collect              : 스트림의 값들을 하나의 결과물로 모으는 최종 연산
        // groupingBy           : 기준이 같은 요소끼리 묶어 Map 생성 (키, 값)
        // Function.identity    : 받은 값을 그대로 돌려주는 함수 (s -> s)
        // Collectors.counting  : 묶음에 담긴 요소의 개수를 Long으로 세는 Collector
        return Arrays.stream(strs)
              .map(this::normalize)
              .filter(Objects::nonNull)
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private int getCount(Map<String, Long> map, String key) {
        return map.getOrDefault(key, 0L).intValue();
    }
}