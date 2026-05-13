import java.util.*;

class Solution {
    private static final String List = null;

    public int[] solution(String[] genres, int[] plays) {

        Map<String, PriorityQueue<Integer[]>> playsMap = new HashMap<>(); // Map<장르, Integer[노래 분류 번호, 노래 재생 횟수]>
        Map<String, Integer> genresMap = new HashMap<>(); // Map<장르, 총 노래 재생 횟수>

        for (int i = 0; i < genres.length; i++) {
            if (!playsMap.containsKey(genres[i])) {
                playsMap.put(genres[i], new PriorityQueue<>((a, b) -> b[1] - a[1]));
            }
            playsMap.get(genres[i]).add(new Integer[] {i, plays[i]});
            
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }

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