import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    class Music implements Comparable<Music> {
        String genres;
        int id;
        int plays;

        Music (String genres, int id, int plays) {
            this.genres = genres;
            this.id = id;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music other) {
            if (this.plays == other.plays) {
                return this.id - other.id;
            }
            return other.plays - this.plays;
        }

        public String getGenres() {
            return genres;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                        .mapToObj(i -> new Music(genres[i], i, plays[i]))
                        .collect(Collectors.groupingBy(Music::getGenres))
                        .entrySet().stream()
                        .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                        .flatMap(x -> x.getValue().stream().sorted().limit(2))
                        .mapToInt(x -> x.id).toArray();
    }

    int sum(List<Music> music) {
        int result = 0;
        for (Music m : music) {
            result += m.plays;
        }
        return result;
    }
}