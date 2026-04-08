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
            int[] max = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                values[i] = Integer.parseInt(st.nextToken());
            }

            max[1] = values[1];
            int maxValue = max[1];

            for (int i = 2; i <= n; i++) { // i번째 원소로 끝나는 연속 수
                if (values[i] < values[i] + max[i - 1]) {
                    max[i] = values[i] + max[i - 1];
                } else {
                    max[i] = values[i];
                }
                if (maxValue < max[i]) maxValue = max[i];
            }

            bw.write(String.valueOf(maxValue));
        }
    }
}