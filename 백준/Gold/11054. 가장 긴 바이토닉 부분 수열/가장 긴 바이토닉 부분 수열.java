import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] values = new int[n + 1];
            int[] flengths = new int[n + 1]; // 앞에 위치한 값들의 최대 길이
            int[] blengths = new int[n + 1]; // 뒤에 위치한 값들의 최대 길이
            for (int i = 1; i <= n; i++) {
                values[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                flengths[i] = 1;
                for (int f = i - 1; f >= 1; f--) {
                    if (values[i] > values[f] && flengths[i] <= flengths[f]) flengths[i] = flengths[f] + 1;
                }
            }
            for (int i = n; i > 0; i--) {
                blengths[i] = 1;
                for (int b = i + 1; b <= n; b++) {
                    if (values[i] > values[b] && blengths[i] <= blengths[b]) blengths[i] = blengths[b] + 1;
                }
            }
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (max < flengths[i] + blengths[i] - 1) {
                    max = flengths[i] + blengths[i] - 1;
                }
            }
            bw.append(Integer.toString(max));
        }
    }
}