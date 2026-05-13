import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // playsMap : Map<장르, Integer[노래 분류 번호, 노래 재생 횟수]>
        Map<String, PriorityQueue<Integer[]>> playsMap = new HashMap<>();
        // genresMap : Map<장르, 총 노래 재생 횟수>
        Map<String, Integer> genresMap = new HashMap<>();

        // playsMap, genresMap 초기화
        for (int i = 0; i < genres.length; i++) {
            playsMap.computeIfAbsent(genres[i], k -> new PriorityQueue<>((a, b) -> b[1] - a[1]))
                    .offer(new Integer[] {i, plays[i]});
            
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // sortList : genresMap (총 노래 재생 횟수) 내림차순 정렬
        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(genresMap.entrySet());
        sortList.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < sortList.size(); i++) {
            int count = 2;
            String genre = sortList.get(i).getKey();

            while (count-- != 0) {
                if (playsMap.get(genre).peek() == null) break;
                answer.add(playsMap.get(genre).poll()[0]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}