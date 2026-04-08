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
            int[] lengths = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                values[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                lengths[i] = 1;
                for (int j = i - 1; j > 0; j--) {
                    if (lengths[i] < lengths[j] + 1 && values[i] < values[j]) {
                        lengths[i] = lengths[j] + 1;
                    }
                }
            }
            int max = 0;
            for (int i : lengths) {
                if (i > max) max = i;
            }
            bw.append(Integer.toString(max));
        }
    }
}